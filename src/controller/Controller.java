package controller;

import gui.FormEvent;
import model.*;

import java.util.List;

public class Controller {

    Database db = new Database();

    public List<Person> getPeople(){
        return db.getPeople();
    }

    public void addPerson(FormEvent ev){
        String name = ev.getName();
        String occupation = ev.getOccupation();
        int ageCatId = ev.getAgeCategory();
        String empCat = ev.getEmploymentCategory();
        boolean isUS = ev.isUsCitizen();
        String taxId = ev.getTaxId();
        String gender = ev.getGender();

        AgeCategory ageCategory;

        switch(ageCatId){
            case 0:
                ageCategory = AgeCategory.child;
                break;
            case 1:
                ageCategory = AgeCategory.adult;
                break;
            case 2:
                ageCategory = AgeCategory.senior;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + ageCatId);
        }

        EmploymentCategory empCategory = null;

        if(empCat.equals("Employed")){
            empCategory = EmploymentCategory.employed;
        }
        else if(empCat.equals("Self-Employed")){
            empCategory = EmploymentCategory.selfEmployed;
        }
        else if(empCat.equals("Unemployed")){
            empCategory = EmploymentCategory.unemployed;
        }
        else{
            empCategory = EmploymentCategory.other;
            System.err.println(empCat);
        }

        Gender genderCat = null;

        if(gender.equals("male")){
            genderCat = Gender.male;
        }
        else {
            genderCat = Gender.female;
        }

        Person person = new Person(name, occupation, ageCategory, empCategory,
                taxId, isUS, genderCat);

        db.addPerson(person);

    }
}
