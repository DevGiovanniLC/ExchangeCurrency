package model;

public record Currency(String Id, Double referenceValue){
    @Override
    public String toString() {
        return this.Id;
    }
}



