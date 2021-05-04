package ConcurrentTest.CountDownLatchTest;

import lombok.Getter;

public enum CountryEnum {
    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕")
    ,FORE(4,"赵"),FIVE(5,"韩"),SIX(6,"魏");
    @Getter private int retCode;
    @Getter private String message;

    CountryEnum(int retCode, String message) {
        this.retCode = retCode;
        this.message = message;
    }

    public static CountryEnum ForEach_CountryEnum(int index){
        for (CountryEnum element : CountryEnum.values()) {
            if (element.retCode==index){
                return element;
            }
        }
        return null;
    }
}
