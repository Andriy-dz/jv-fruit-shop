package service.impl;

import java.util.List;
import service.ValidatorService;

public class ValidatorServiceImpl implements ValidatorService {
    private static final int NUMBER_OF_COLUMN = 3;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public boolean isValidData(List<String> list) {
        if (list.size() == 0) {
            throw new RuntimeException("File is Empty");
        }
        if (list.get(0).equals("type,fruit,quantity")) {
            list.remove(0);
        }
        for (String string : list) {
            String[] strings = string.split(",");
            int quantity;
            try {
                quantity = Integer.parseInt(strings[INDEX_OF_QUANTITY]);
            } catch (RuntimeException e) {
                throw new RuntimeException("Error!! the third parameter must be a number");
            }
            if (strings.length != NUMBER_OF_COLUMN || quantity < 0) {
                throw new RuntimeException("Invalid data");
            }
        }
        return true;
    }
}
