package com.github.roboboredom.CSC251Project;

import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/** Demo/driver class for Policy class.
    @author Willem Dawson Gray          */
public class CProjectWillemGray
{
    /* ========================= FIELDS ========================= */
    /** Number of policy objects created. */
    private static int sm_iPolicyObjectsCreated;

    /* ========================= METHODS ========================= */
    /** Program entrypoint.
        @param a_sArgs Command line arguments to the program. */
    public static void main(String[] a_sArgs)
    {
        /* Initialize two int vars to count the number of policyholders that are smokers and that are non-smokers. */
        int iSmokers    = 0;
        int iNonSmokers = 0;

        try
        {
            /* Initialize a scanner to read from the PolicyInformation.txt file. */
            Scanner oScanner = new Scanner(new File(".." + File.separator + "res" + File.separator + "PolicyInformation.txt"));

            /* Intialize an arraylist to store all the needed policy objects. */
            ArrayList<CPolicy> al_oPolicies = new ArrayList<CPolicy>();

            /* Iterate through the file and populate the arraylist with policy objects constructed with the data in the file. */
            while(oScanner.hasNext())
            {
                CPolicyHolder oPolicyHolder = new CPolicyHolder();
                CPolicy oPolicy = new CPolicy();

                /* Scan in the data in the file to the policy object. */
                oPolicy.fSetPolicyNumber(Integer.parseInt(oScanner.nextLine()));
                oPolicy.fSetProvider(oScanner.nextLine());
                
                oPolicyHolder.fSetFirstName(oScanner.nextLine());
                oPolicyHolder.fSetLastName(oScanner.nextLine());
                oPolicyHolder.fSetAge(Integer.parseInt(oScanner.nextLine()));

                String sInput = oScanner.nextLine();
                if (sInput.equals("smoker"))
                {
                    oPolicyHolder.fSetSmokingStatus(CPolicyHolder.m_ESmokingStatus.SMOKER);

                    /* Increment the counter of policy holders that smoke. */
                    iSmokers++;
                }
                else if (sInput.equals("non-smoker"))
                {
                    oPolicyHolder.fSetSmokingStatus(CPolicyHolder.m_ESmokingStatus.NON_SMOKER);

                    /* Increment the counter of policy holders that don't smoke. */
                    iNonSmokers++;
                }

                oPolicyHolder.fSetHeightInches(Double.parseDouble(oScanner.nextLine()));
                oPolicyHolder.fSetWeightPounds(Double.parseDouble(oScanner.nextLine()));

                oPolicy.fSetPolicyHolder(oPolicyHolder);

                /* Consume the blank line exists after each policy object's data, if it exists. */
                if (oScanner.hasNext()) { oScanner.nextLine(); }

                /* Add the policy to the arraylist. */
                al_oPolicies.add(oPolicy);

                /* Increment the counter of created policy objects. */
                sm_iPolicyObjectsCreated++;
            }

            /* Iterate through all the policy objects in the array and print the data for each. */
            for (CPolicy oPolicy : al_oPolicies)
            {
                System.out.println(oPolicy);
                System.out.println(oPolicy.fGetPolicyHolder());
                System.out.println("Policy Price: $" + String.format("%,.2f", oPolicy.fCalculatePolicyPrice()) + "\n");
            }

            /* Print the number of policy objects created. */
            System.out.println("There were " + sm_iPolicyObjectsCreated + " Policy objects created.");

            /* Print the number of policyholders that are smokers and the amount that are non-smokers. */
            System.out.println("The number of policies with a smoker is: " + iSmokers);
            System.out.println("The number of policies with a non-smoker is: " + iNonSmokers);

            /* Close the scanner to prevent a resource leak. */
            oScanner.close();
        }
        catch (IOException e)
        {
            System.out.println("[ERROR] Failed attempting to read file \"../res/PolicyInformation.txt\".");
        }
    }
}