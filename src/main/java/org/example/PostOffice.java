package org.example;

import org.example.exception.BoxInWrongPackageException;
import org.example.exception.NotEnoughBoxesForPackageException;
import org.example.exception.PackageIsToHeavyException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostOffice {
    List<PostalMatters> postalMattersList;

    public PostOffice(List<PostalMatters> postalMattersList) {
        this.postalMattersList = postalMattersList;
    }

    public PostOffice() {
        postalMattersList = new ArrayList<>();
    }

    public void listAllPostalMatterOnGivenDate(LocalDate date){
        for (PostalMatters post : postalMattersList) {
            if(post.getDate().equals(date)){
                System.out.println(post);
            }
        }
    }

    public double calculateTotalIncomeFromType(String type){
        return switch (type.toLowerCase()) {
            case "letter" -> calculateTotalIncomeFromLetters();
            case "small box" -> calculateTotalIncomeFromSmallBoxes();
//            case "big box" -> calculateTotalIncomeFromBigBoxes();
//            case "package" -> calculateTotalIncomeFromPackages();
            default -> 0.0;
        };
    }

    private double calculateTotalIncomeFromSmallBoxes() {
        double income = 0.0;
        for (PostalMatters post: postalMattersList) {
            if(post.getClass().getSimpleName().equals("Box") && ((Box) post).getType().equals(BoxType.SMALL)){
                income += post.getPrice();
            }
        }
        return income;
    }

    private double calculateTotalIncomeFromLetters() {
        double income = 0.0;
        for (PostalMatters post: postalMattersList) {
            if(post.getClass().getSimpleName().equals("Letter")){
                income += post.getPrice();
            }
        }
        return income;
    }

    public void createPackage(List<Box> boxes){
        try{
            Package newPackage = new Package(boxes);
            postalMattersList.add(newPackage);
        } catch (BoxInWrongPackageException | NotEnoughBoxesForPackageException | PackageIsToHeavyException e){
            System.out.println(e.getMessage());
        }
    }
}
