package org.example;

import org.example.exception.BoxInWrongPackageException;
import org.example.exception.NotEnoughBoxesForPackageException;
import org.example.exception.PackageIsToHeavyException;

import java.util.List;

public class Package extends PostalMatters{
    private final int MAX_ALLOWED_WEIGHT = 5000;
    private List<Box> boxes;

    public Package(List<Box> boxes) throws NotEnoughBoxesForPackageException, BoxInWrongPackageException, PackageIsToHeavyException {
        super(boxes.get(0).getAddress(), boxes.get(0).getName(), boxes.get(0).getDate());
        if(boxes.size() < 2){
            throw new NotEnoughBoxesForPackageException("There must be at least 2 boxes in a package!");
        }

        if(!boxesInRightPackage(boxes)){
            throw new BoxInWrongPackageException("There are boxes that do not go with the others!");
        }

        if(calculateTotalWeight(boxes) > MAX_ALLOWED_WEIGHT){
            throw new PackageIsToHeavyException("This box is " + (calculateTotalWeight(boxes) - MAX_ALLOWED_WEIGHT) + " grams over the weight limit!");
        }

        this.boxes = boxes;
        setPrice(calculatePrice());
    }

    private double calculatePrice() {
        double price = 0.0;
        for (Box box : boxes) {
            price += box.getPrice();
        }

        return price * 0.9;
    }

    private int calculateTotalWeight(List<Box> boxes) {
        int weight = 0;
        for (Box box : boxes) {
            weight += box.getWeight();
        }
        return weight;
    }

    private boolean boxesInRightPackage(List<Box> boxes) {
        for (Box box : boxes) {
            if(boxDiffersFromPackage(box)){
               return false;
            }
        }
        return true;
    }

    private boolean boxDiffersFromPackage(Box box) {
        return !box.getAddress().equals(this.getAddress()) || !box.getName().equals(this.getName())
                || !box.getDate().equals(getDate());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Package from: ").append(getName()).append("\n");
        builder.append("To: ").append(getAddress()).append("\n");
        builder.append("Containing: ").append("\n");
        for (Box box: boxes) {
            builder.append(box.toString()).append("\n");
        }
        return builder.toString();
    }
}
