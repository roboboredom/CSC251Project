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
* Basically, I like it because it makes the code just verbose enough to be easier for me to read quickly,
* without doing something crazy like: "ClassName_ArrayListOfBool_BlockState" or just relying on the IDE,
* (which may or may not support type display).
*
* https://en.wikipedia.org/wiki/Hungarian_notation
*/

package com.github.roboboredom.CSC251Project;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
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
        /* Initialize an arraylist to hold our insurance policy objects. */
        ArrayList<CPolicy> al_oPolicies= new ArrayList<CPolicy>();

        /* Place file handling logic in a try-catch block so that any exceptions regarding files
         * are caught and reported to the user instead of just exiting or crashing ambiguously.
         */
        try
        {
            /* Intialize a file handler. Set it to the Policyinformation.txt file.
            * When passing in the filepath, use the OS-dependent file separator.
            */
            File oPolicyInformationFile = new File("assets" + File.separator + "policyinformation.txt");

            /* Initialize a scanner; pass to it the file.
            * Set it to use only the OS-dependent line separator
            * sequence as the delimiter, instead of any whitespace.
            */
            Scanner oScanner = new Scanner(oPolicyInformationFile);
            oScanner.useDelimiter(System.lineSeparator());

            /* Scan in the items from the file. */
            while(oScanner.hasNext())
            {
                int iPolicyNumber = Integer.parseInt(oScanner.next());
                String sProviderName = oScanner.next();
                String sPolicyHolderFirstName = oScanner.next();
                String sPolicyHolderLastName = oScanner.next();
                int iPolicyHolderAge = Integer.parseInt(oScanner.next());

                CPolicy.m_ESmokingStatus ePolicyHolderSmokingStatus = CPolicy.m_ESmokingStatus.NON_SMOKER;
                if (oScanner.next().equalsIgnoreCase("smoker"))
                {
                    ePolicyHolderSmokingStatus = CPolicy.m_ESmokingStatus.SMOKER;
                }

                double dPolicyHolderHeightInches = Double.parseDouble(oScanner.next());
                double dPolicyHolderWeightPounds = Double.parseDouble(oScanner.next());

                /* Don't read the BMI and price from the file, those can be calculated
                 * at runtime from the above data for a tiny CPU cost so are redundant.
                 */

                /* It seems pointless to use these named buffer variables when 
                 * you could read in and send the data inline below, but that 
                 * would be a lot less readable. */
                al_oPolicies.add(new CPolicy(
                    iPolicyNumber,
                    sProviderName,
                    sPolicyHolderFirstName,
                    sPolicyHolderLastName,
                    iPolicyHolderAge,
                    ePolicyHolderSmokingStatus,
                    dPolicyHolderHeightInches,
                    dPolicyHolderWeightPounds)
                );

                /* Skip any blank tokens if we have not reached the end of the file. */
                if(oScanner.hasNext())
                {
                    oScanner.next();
                }
            }

            /* Close the scanner to prevent a resource leak. */
            oScanner.close();
        }
        catch(IOException oIOException)
        {
            /* Inform the user of the IOException error and what file it occured with. */
            System.out.println("Error trying to read \"assets" + File.separator + "policyinformation.txt\": " + oIOException.getMessage());
        }

        /* Traverse through the list and print out the data for each insurance policy object.
        * While doing so, keep track of the # of non-smokers & smokers and print the totals after.
        */
        int iNonSmokerCount = 0;
        int iSmokerCount = 0;

        for (CPolicy oPolicy : al_oPolicies)
        {
            System.out.println("Policy Number: " + oPolicy.fGetPolicyNumber());
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
            * affect the insurance policy cost.
            */
            CPolicy.m_ESmokingStatus ePolicyHolderSmokingStatus = oPolicy.fGetPolicyHolderSmokingStatus();
            if (ePolicyHolderSmokingStatus == CPolicy.m_ESmokingStatus.NON_SMOKER)
            {
                iNonSmokerCount++;
                System.out.println("Policyholder's Smoking Status: non-smoker");
            }
            else
            {
                iSmokerCount++;
                System.out.println("Policyholder's Smoking Status: smoker");
            }

            System.out.println("Policyholder's Height: " + String.format("%.1f", oPolicy.fGetPolicyHolderHeightInches()) + " inches");
            System.out.println("Policyholder's Weight: " + String.format("%.1f", oPolicy.fGetPolicyHolderWeightPounds()) + " pounds");

            /* Run the needed calculations and print out the BMI and total insurance policy price */
            System.out.println("Policyholder's BMI: " + String.format("%.2f", oPolicy.fCalculatePolicyHolderBMI()));
            System.out.println("Policy Price: $" + String.format("%.2f", oPolicy.fCalculateInsurancePolicyPrice()) + "\n"); // newline to space out each policies' data
        }

        /* Print the smoker totals */
        System.out.println("The number of policies with a smoker is: " + iSmokerCount);
        System.out.println("The number of policies with a non-smoker is: " + iNonSmokerCount);
    }
}