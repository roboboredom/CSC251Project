/* 
* This project uses the following naming convention ontop of the teacher required one: 
* An old convention called hungarian notation.
* It is considered outdated by some because most modern IDEs display type directly,
* but I prefer it because not only does it prevent name collisions, it allows you to see
* what type something is outside the IDE without browsing the code directly.
* It also allows you to "search" autocomplete by typing a prefix.

* Key for this project:
*     i   int
*     d   double
*     b   boolean
*     s   string
*     f   function
*     e   enum instance
*     E   enum declaration
*     C   class declaration
*     m_  member of a class
*     o   class instance (object)
*     a_  array of
*     al_ arraylist of
*     F_  final
*
* Prefixes can be combined in logical ways, such as:
*     "m_al_bBlockState" class member, arraylist of booleans, named BlockState
*
* Basically, I like it because it makes the code just verbose enough to be easier for me to read quickly, without doing something crazy like:
*     "ClassName_ArrayListOfBool_BlockState" or just relying on the IDE (which may or may not support type display
*
* https://en.wikipedia.org/wiki/Hungarian_notation
*/

package com.github.roboboredom.CSC251Project;

import java.util.Scanner;

/**
 * Demo / driver class for CPolicy.
 * <ul>
 *     <li>This class contains the main method.
 *     </li>
 * </ul>
 * 
 * @author Willem Dawson Gray
 */
public class Project_willem_gray
{
    /** Program entrypoint. 
     * @param a_sArgs Command line arguments to the program
    */
    public static void main(String[] a_sArgs)
    {
        /* Initialize a scanner and also a new policy object */
        Scanner oScanner = new Scanner(System.in);
        CPolicy oPolicy = new CPolicy();

        /* Prompt the user to enter the required policy data */
        /* There is NO input santization here, but the project did not say it was required. */
        System.out.print("Please enter the Policy Number: ");
        oPolicy.fSetPolicyNumber(oScanner.nextInt());
        oScanner.nextLine();

        System.out.print("Please enter the Provider Name: ");
        oPolicy.fSetProviderName(oScanner.nextLine());
        
        System.out.print("Please enter the Policyholder's First Name: ");
        oPolicy.fSetPolicyHolderFirstName(oScanner.nextLine());

        System.out.print("Please enter the Policyholder's Last Name: ");
        oPolicy.fSetPolicyHolderLastName(oScanner.nextLine());

        System.out.print("Please enter the Policyholder's Age: ");
        oPolicy.fSetPolicyHolderAge(oScanner.nextInt());
        oScanner.nextLine();

        System.out.println("Please enter the Policyholder's Smoking Status (smoker/non-smoker): ");
        String sInput = oScanner.nextLine();
        if (sInput.equals("smoker"))
        {
            oPolicy.fSetPolicyHolderSmokingStatus(CPolicy.m_ESmokingStatus.SMOKER);
        }
        else if (sInput.equals("non-smoker"))
        {
            oPolicy.fSetPolicyHolderSmokingStatus(CPolicy.m_ESmokingStatus.NON_SMOKER);
        }

        System.out.print("Please enter the Policyholder's Height (in inches): ");
        oPolicy.fSetPolicyHolderHeightInches(oScanner.nextDouble());
        oScanner.nextLine();

        System.out.print("Please enter the Policyholder's Weight (in pounds): ");
        oPolicy.fSetPolicyHolderWeightPounds(oScanner.nextDouble());
        oScanner.nextLine();

        /* Print out all the entered data */
        System.out.println("\nPolicy Number: " + oPolicy.fGetPolicyNumber());
        System.out.println("Provider Name: " + oPolicy.fGetProviderName());
        System.out.println("Policyholder's First Name: " + oPolicy.fGetPolicyHolderFirstName());
        System.out.println("Policyholder's Last Name: " + oPolicy.fGetPolicyHolderLastName());
        System.out.println("Policyholder's Age: " + oPolicy.fGetPolicyHolderAge());

        /* There is probably a better way of doing this, but this works okay. 
         * I am talking about printing the name of the enum state. NOT if this should be a boolean.
         * 
         * This should be an enum, because the program may need to be extended to support other 
         * smoking states later on, such as "ECIG_SMOKER, etc.", since this is insurance, and 
         * different drug types that can be smoked have different risk factors that should
         * affect the insurance policy cost 
         */
        CPolicy.m_ESmokingStatus ePolicyHolderSmokingStatus = oPolicy.fGetPolicyHolderSmokingStatus();
        if (ePolicyHolderSmokingStatus == CPolicy.m_ESmokingStatus.NON_SMOKER)
        {
            System.out.println("Policyholder's Smoking Status: non-smoker");
        }
        else
        {
            System.out.println("Policyholder's Smoking Status: smoker");
        }

        System.out.println("Policyholder's Height: " + String.format("%.1f", oPolicy.fGetPolicyHolderHeightInches()) + " inches");
        System.out.println("Policyholder's Weight: " + String.format("%.1f", oPolicy.fGetPolicyHolderWeightPounds()) + " pounds");

        /* Run the needed calculations and print out the BMI and total insurance policy price */
        System.out.println("Policyholder's BMI: " + String.format("%.2f", oPolicy.fCalculatePolicyHolderBMI()));
        System.out.println("Policy Price: $" + String.format("%.2f", oPolicy.fCalculateInsurancePolicyPrice()));

        /* Close the scanner to prevent a resource leak */
        oScanner.close();

        /* This program could loop, but the teacher did not say to use a read-eval-print-loop (REPL) structure for this particular project */
    }
}