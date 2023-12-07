package model;

public record Currency(String Id, Double referenceRate){
    @Override
    public String toString() {
        return this.Id;
    }
}



