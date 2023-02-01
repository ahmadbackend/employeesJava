package emplyoess;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class  Employee  {


   private final static String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
   protected final static Pattern peoplePat = Pattern.compile(peopleRegex);
   protected final NumberFormat money = NumberFormat.getCurrencyInstance();
   protected final Matcher peopleMat;
   protected String lastName;
   protected String firstName;
   protected LocalDate dob;
   DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("M/d/yyyy");

   public Employee(String person) {
      peopleMat =Employee.peoplePat.matcher(person);
      if (peopleMat.find()) {
         this.lastName = peopleMat.group("lastName");
         this.firstName = peopleMat.group("firstName");
         this.dob = LocalDate.from(dtformat.parse(peopleMat.group("dob")));
      }
   }

   public abstract int getSalary();

   public static final Employee getText (String personText)throws Exception {
       Matcher peopleMat= peoplePat.matcher (personText);
       if(peopleMat.find())
       {
           return switch (peopleMat.group("role")) {

               case "Programmer" -> new Programmer(personText);

               case "Manager" -> new Manager(personText);

               case "Analyist" -> new Analyist(personText);

               case "CEO" -> new CEO(personText);

           };
       }
       else
       {
           //practicing exceptions
           throw new Exception("emplye category not known kindly check the staff category");
       }
   }

      @Override
      public String toString () {
         return String.format("%s,  %s: %S%n", lastName, firstName, money.format(getSalary()));

      }
   }
