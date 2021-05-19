package ru.petshop.model;

import lombok.Getter;

@Getter
public enum PositionEnum {

    DEVELOPER("Разработчик",1),
    DESIGNER("Дизайнер",2),
    MANAGER("Менеджер", 3),
    DIRECTOR("Директор",4);


    private String positionName;
    private Integer positionIndex;

    PositionEnum(String positionName, Integer positionIndex) {
        this.positionName = positionName;
        this.positionIndex = positionIndex;
    }

    public static Integer getPositionIndexByPositionName(String positionName) {
        for (PositionEnum positionEnum : PositionEnum.values()) {
            if (positionEnum.getPositionName().equals(positionName)) {
                return positionEnum.getPositionIndex();
            }
        }
        throw new EnumConstantNotPresentException(PositionEnum.class,positionName);
    }
}
