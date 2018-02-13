package ru.testing.cofeeshop.app.console;

import ru.testing.cofeeshop.config.ApplicationContext;
import ru.testing.cofeeshop.config.value.ApplicationInstanceType;
import ru.testing.cofeeshop.controller.OrderController;
import ru.testing.cofeeshop.controller.ProductController;
import ru.testing.cofeeshop.controller.model.BasketDTO;
import ru.testing.cofeeshop.controller.model.BasketItemDTO;
import ru.testing.cofeeshop.controller.model.ProductDTO;
import ru.testing.cofeeshop.controller.model.UserDTO;
import ru.testing.cofeeshop.domain.entity.Basket;
import ru.testing.cofeeshop.domain.entity.Order;
import ru.testing.cofeeshop.domain.value.OptionType;
import ru.testing.cofeeshop.domain.value.PaymentType;
import ru.testing.cofeeshop.domain.value.ProductCategory;
import ru.testing.cofeeshop.domain.value.ProductType;
import ru.testing.cofeeshop.productcatalog.resource.AvailableProduct;
import ru.testing.cofeeshop.utils.reliability.OperationException;
import ru.testing.cofeeshop.utils.reliability.OperationResultStatus;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BillingCycleUI {

    public static void initialize() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            userGreeting(br);
            boolean continueShopping;
            do {
                startBillingCycle(br);
                continueShopping = continueOrExit(br);
            } while (continueShopping);
        } catch (IOException e) {
            System.err.println(String.format("\nSorry! Our shop has been closed by the technical reasons (I/O problems) with error %s.", e.getMessage()));
        }
    }

    private static void startBillingCycle(BufferedReader br) throws IOException {
        clearConsole();
        System.out.println(String.format("\nWell, dear %s. What can we do for you?", ApplicationContext.getUserDetails().getUsername()));
        fillBasket(br);
    }

    private static void fillBasket(BufferedReader br) throws IOException {
        System.out.print("\nMay be some cup of tea or coffee?\n\n1 - tea\n2 - coffee\n3 - just some add ons\nexit - not interesting\n\nAnswer: ");
        ProductCategory checkedCategory = chooseProductType(br);
        chooseProductDetails(br, null, checkedCategory, ProductType.BASE);
    }

    private static ProductCategory chooseProductType(BufferedReader br) throws IOException {
        boolean isGood = true;
        do {
            String answer = br.readLine();
            switch (answer) {
                case "1":
                    return ProductCategory.TEA;
                case "2":
                    return ProductCategory.COFFEE;
                case "3":
                    return ProductCategory.ADD_ON;
            }
            isGood = checkIsExit(answer);
        } while (!isGood);
        throw new OperationException(OperationResultStatus.FAILURE_INTERNAL_UNKNOWN, "Can't choose product Type!");
    }

    private static void chooseProductDetails(BufferedReader br, ProductDTO baseProduct, ProductCategory checkedCategory, ProductType productType) throws IOException {

        AvailableProduct checkedProduct = chooseAvailableCategoryOfProduct(br, checkedCategory);

        Integer amount = chooseAmountOfProduct(br, checkedProduct);

        ProductDTO generatedProduct = null;
        if (productType.equals(ProductType.ADD_ON)) {
            //response is add-on
            generatedProduct = ((ProductController) ApplicationContext.getGenericControllerMap().get(ApplicationInstanceType.PRODUCT)).addAddonToProduct(baseProduct.getId(), checkedProduct, amount);
        } else if (productType.equals(ProductType.BASE)) {
            generatedProduct = ((ProductController) ApplicationContext.getGenericControllerMap().get(ApplicationInstanceType.PRODUCT)).addProductToBasket(checkedProduct, amount);
        } else {
            throw new OperationException(OperationResultStatus.FAILURE_INTERNAL_UNKNOWN, "Unknown product Type to choose product details!");
        }
        generatedProduct = chooseOptions(br, generatedProduct);
        if (baseProduct == null) {
            baseProduct = generatedProduct;
        }
        if (!checkedCategory.equals(ProductCategory.ADD_ON) && !productType.equals(ProductType.ADD_ON)) {
            chooseAddons(br, baseProduct);
        }
    }

    private static ProductDTO chooseOptions(BufferedReader br, ProductDTO generatedProduct) throws IOException {
        if (generatedProduct.getAvailableProduct().toString().contains(ProductCategory.MILK_ADD_ON.toString())) {
            System.out.print("\nHow much of this fat number you want (1..10)?\n\nAnswer: ");
        } else if (generatedProduct.getAvailableProduct().toString().contains(ProductCategory.SWEET_ADD_ON.toString())) {
            System.out.print("\nHow much of sweetest number you want (1..10)?\n\nAnswer: ");
        } else if (generatedProduct.getAvailableProduct().toString().contains(ProductCategory.TEA.toString())
                || generatedProduct.getAvailableProduct().toString().contains(ProductCategory.COFFEE.toString())) {
            System.out.print("\nWhat volume for this Cup of product you need?\n1 - 200\n2 - 300\n3 - 500\n\nAnswer: ");
        }
        boolean isGood = true;
        do {
            String answerProductAmount = br.readLine();
            if (isNumeric(answerProductAmount)) {
                Integer choosedAmount = Integer.valueOf(answerProductAmount);
                if (choosedAmount > 0) {
                    if (generatedProduct.getAvailableProduct().toString().contains(ProductCategory.ADD_ON.toString())) {
                        if (choosedAmount < 11) {
                            if (generatedProduct.getAvailableProduct().toString().contains(ProductCategory.MILK_ADD_ON.toString())) {
                                return createAndSetOption(OptionType.FAT_CONTENT, choosedAmount, generatedProduct.getId());
                            } else if (generatedProduct.getAvailableProduct().toString().contains(ProductCategory.SWEET_ADD_ON.toString())) {
                                return createAndSetOption(OptionType.SUGAR_CONTENT, choosedAmount, generatedProduct.getId());
                            } else {
                                throw new OperationException(OperationResultStatus.FAILURE_INTERNAL_UNKNOWN, "Can't choose product Available Category!");
                            }
                        }
                    } else if (generatedProduct.getAvailableProduct().toString().contains(ProductCategory.TEA.toString())
                            || generatedProduct.getAvailableProduct().toString().contains(ProductCategory.COFFEE.toString())) {
                        switch (choosedAmount) {
                            case 1:
                                return createAndSetOption(OptionType.VOLUME, 200, generatedProduct.getId());
                            case 2:
                                return createAndSetOption(OptionType.VOLUME, 300, generatedProduct.getId());
                            case 3:
                                return createAndSetOption(OptionType.VOLUME, 500, generatedProduct.getId());
                        }
                    }
                }
            }
            isGood = checkIsExit(answerProductAmount);
        } while (!isGood);
        throw new OperationException(OperationResultStatus.FAILURE_INTERNAL_UNKNOWN, "Can't choose product Option!");
    }

    private static ProductDTO createAndSetOption(OptionType optionType, Integer choosedAmount, Long productId) {
        return ((ProductController) ApplicationContext.getGenericControllerMap().get(ApplicationInstanceType.PRODUCT)).addOptionToProduct(optionType, choosedAmount, productId);
    }

    private static void chooseAddons(BufferedReader br, ProductDTO baseProduct) throws IOException {
        System.out.print("\nDo you want to add some add-ons\n1 - Yes\n2 - No\n\nAnswer: ");
        boolean continueAdd = false;
        do {
            if (continueAdd) {
                System.out.print("\nDo you want to add some Another add-on?\n1 - Yes\n2 - No\n\nAnswer: ");
            }
            String answer = br.readLine();
            switch (answer) {
                case "1":
                    chooseProductDetails(br, baseProduct, ProductCategory.ADD_ON, ProductType.ADD_ON);
                    continueAdd = true;
                    break;
                case "2":
                    continueAdd = false;
                    return;
                default:
                    continueAdd = true;
            }
        } while (continueAdd);
        throw new OperationException(OperationResultStatus.FAILURE_INTERNAL_UNKNOWN, "Choose addons error!");
    }

    private static Integer chooseAmountOfProduct(BufferedReader br, AvailableProduct checkedProduct) throws IOException {
        if (checkedProduct.toString().contains(ProductCategory.ADD_ON.toString())) {
            System.out.print("\nWhat amount of this addon you want?\n\nAnswer: ");
        } else {
            System.out.print("\nWhat amount of this product you need?\n\nAnswer: ");
        }
        boolean isGood = true;
        do {
            String answerProductAmount = br.readLine();
            if (isNumeric(answerProductAmount)) {
                Integer choosedAmount = Integer.valueOf(answerProductAmount);
                if (choosedAmount > 0) {
                    return choosedAmount;
                }
            }
            isGood = checkIsExit(answerProductAmount);
        } while (!isGood);
        throw new OperationException(OperationResultStatus.FAILURE_INTERNAL_UNKNOWN, "Can't choose this amount to product!");
    }

    private static AvailableProduct chooseAvailableCategoryOfProduct(BufferedReader br, ProductCategory checkedCategory) throws IOException {
        System.out.println("\nOK. Which kind from this list do you want?\n");
        List<AvailableProduct> availableProducts = new ArrayList<>();
        for (AvailableProduct product : AvailableProduct.values()) {
            if (product.toString().toLowerCase().contains(checkedCategory.toString().toLowerCase())) {
                availableProducts.add(product);
            }
        }
        for (int i = 0; i < availableProducts.size(); i++) {
            System.out.println(String.format("%d - %s", i + 1, availableProducts.get(i).getValue()));
        }
        System.out.print("\nAnswer: ");
        boolean isGood = true;
        do {
            String answerProductType = br.readLine();
            if (isNumeric(answerProductType)) {
                Integer choosedIndex = Integer.valueOf(answerProductType) - 1;
                if (choosedIndex < availableProducts.size() && choosedIndex >= 0) {
                    return availableProducts.get(choosedIndex);
                }
            }
            isGood = checkIsExit(answerProductType);
        } while (!isGood);
        throw new OperationException(OperationResultStatus.FAILURE_INTERNAL_UNKNOWN, "Can't choose product Available Category!");
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    private static void userGreeting(BufferedReader br) throws IOException {
        clearConsole();
        System.out.print("\nDear client!\nWe're happy to see you here. How would you want us to call you?\n\n1 - introduce myself\n2 - get shopping without greeting\nexit - quit\n\nAnswer: ");
        boolean isGood = true;
        do {
            String answer = br.readLine();
            switch (answer) {
                case "1":
                    readUsernameAndCountry(br);
                    return;
                case "2":
                    return;
            }
            isGood = checkIsExit(answer);
        } while (!isGood);
    }

    private static void readUsernameAndCountry(BufferedReader br) throws IOException {
        clearConsole();
        System.out.print("\nWell. How would you want us to call you?\n\nEnter your name: ");
        UserDTO userDTO = new UserDTO();
        userDTO.setName(br.readLine());
        System.out.print("\nEnter your country: ");
        userDTO.setCountry(br.readLine());
        ApplicationContext.getUserController().updateUser(userDTO);
    }

    private static boolean continueOrExit(BufferedReader br) throws IOException {
        clearConsole();
        System.out.print("\n\nDo you want to continue shopping or that's all?\n\n1 - continue shopping\n2 - make order\nexit - say goodbye and run away\n\nAnswer: ");
        boolean isGood = true;
        do {
            String answer = br.readLine();
            switch (answer) {
                case "1":
                case "Y":
                case "y":
                case "continue":
                    return true;
                case "2":
                    processOrder(br);
                    return true;
            }
            isGood = checkIsExit(answer);
        } while (!isGood);
        return false;
    }

    private static void processOrder(BufferedReader br) throws IOException {
        clearConsole();
        BasketDTO basket = ApplicationContext.getUserController().getBasket();
        System.out.println(String.format("\nMaking order with:\n%s products and totalCost: %s", basket.getSize().toString(), basket.getTotalCost().toString()));
        printCheque(basket);
        PaymentType paymentType = getPayment(br);
        Order order = ((OrderController) ApplicationContext.getGenericControllerMap().get(ApplicationInstanceType.ORDER)).processOrder(paymentType);
        System.out.println(String.format("\nSuccessfully Paid! Order №%d with TotalCost: %s", order.getId(), order.getTotalCost().toString()));
    }

    private static void printCheque(BasketDTO basket) {
        int i = 0;
        for (BasketItemDTO basketItem : basket.getItemSet()) {
            System.out.println(String.format("%d: totalcost:%s, amount: %d, product: %s", i + 1, basketItem.getProductDTO().getTotalCost(), basketItem.getAmount(), basketItem.getProductDTO().getName()));
            if (!basketItem.getProductDTO().getOptionList().isEmpty()) {
                System.out.println("\t Options: ");
                for (int i1 = 0; i1 < basketItem.getProductDTO().getOptionList().size(); i1++) {
                    System.out.println(String.format("\t\t%d: name: %s, value: %s",
                            basketItem.getProductDTO().getOptionList().get(i1).getName(),
                            basketItem.getProductDTO().getOptionList().get(i1).getValue().toString()));
                }
            }
            if (!basketItem.getProductDTO().getAddOns().isEmpty()) {
                System.out.println("\t Options: ");
                //TODO: distinct by addon product type
                for (int i1 = 0; i1 < basketItem.getProductDTO().getAddOns().size(); i1++) {
                    System.out.println(String.format("\t%d: name: %s, cost: %s",
                            basketItem.getProductDTO().getAddOns().get(i1).getName(),
                            basketItem.getProductDTO().getAddOns().get(i1).getTotalCost().toString()));
                }
            }
            i++;
        }
    }

    private static PaymentType getPayment(BufferedReader br) throws IOException {
        System.out.println("\nChoose your payment type:");
        int i = 0;
        for (PaymentType paymentType : PaymentType.values()) {
            System.out.println(String.format("%d - %s", i + 1, paymentType.toString()));
            i++;
        }
        System.out.print("Answer: ");

        boolean isGood = true;
        do {
            String answerPaymentType = br.readLine();
            if (isNumeric(answerPaymentType)) {
                Integer choosedIndex = Integer.valueOf(answerPaymentType) - 1;
                if (choosedIndex < PaymentType.values().length && choosedIndex > 0) {
                    return PaymentType.values()[choosedIndex];
                }
            }
            isGood = checkIsExit(answerPaymentType);
        } while (!isGood);
        throw new OperationException(OperationResultStatus.FAILURE_INTERNAL_UNKNOWN, "Can't choose Payment Type!");
    }

    private static boolean checkIsExit(String answer) {
        switch (answer) {
            case "quit":
            case "exit":
                exitShop("\nWe have the best coffee for you. So, we'll waiting for you. Have a nice day!");
                break;
            default:
                System.out.println("Unknown answer. Repeat again!");
                return false;
        }
        return true;
    }

    private static void exitShop(String message) {
        System.out.println(message);
        System.exit(0);
    }

    private static void clearConsole() {
        try {
            System.out.print("\033[H\033[2J");
            Console c = System.console();
            if (c != null) {
                c.flush();
            }
            if (System.getProperty("os.name").contains("Windows")) {
                Runtime.getRuntime().exec("cmd /c cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            System.err.println(String.format("Can't clear console with error %s!", e.getMessage()));
        } finally {
            System.out.flush();
            System.out.println("Coffee Shop App.\tBy Vasiliev Alexander <alexandrvasilievby@gmail.com>.");
            Basket basket = ApplicationContext.getUserDetails().getBasket();
            if (basket.getSize() > 0) {
                System.out.print(String.format("Basket size: %s, totalCost: %s", basket.getSize().toString(), basket.getTotalCost().toString()));
            }
        }
    }
}
