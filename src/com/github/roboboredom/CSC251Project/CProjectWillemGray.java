package com.github.roboboredom.CSC251Project;

import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/** Demo/driver class for Policy class.
    @author Willem Dawson Gray          */
public class CProjectWillemGray
{
    /** Program entrypoint.
        @param a_sArgs Command line arguments to the program. */
    public static void main(String[] a_sArgs)
    {
        System.out.println("[DEBUG] CWD: " + System.getProperty("user.dir"));

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
                CPolicy oPolicy = new CPolicy();

                /* Scan in the data in the file to the policy object. */
                oPolicy.fSetPolicyNumber(Integer.parseInt(oScanner.nextLine()));

                oPolicy.fSetProvider(oScanner.nextLine());
                oPolicy.fSetFirstName(oScanner.nextLine());
                oPolicy.fSetLastName(oScanner.nextLine());

                oPolicy.fSetAge(Integer.parseInt(oScanner.nextLine()));

                String sInput = oScanner.nextLine();
                if (sInput.equals("smoker"))
                {
                    oPolicy.fSetSmokingStatus(CPolicy.m_ESmokingStatus.SMOKER);
                }
                else if (sInput.equals("non-smoker"))
                {
                    oPolicy.fSetSmokingStatus(CPolicy.m_ESmokingStatus.NON_SMOKER);
                }

                oPolicy.fSetHeightInches(Double.parseDouble(oScanner.nextLine()));
                oPolicy.fSetWeightPounds(Double.parseDouble(oScanner.nextLine()));

                /* Consume the blank line exists after each policy object's data, if it exists. */
                if (oScanner.hasNext()) { oScanner.nextLine(); }

                /* Add the policy to the arraylist. */
                al_oPolicies.add(oPolicy);
            }

            /* Iterate through all the policy objects in the array and print the data for each. */
            for (CPolicy oPolicy : al_oPolicies)
            {
                System.out.println("Policy Number: " + oPolicy.fGetPolicyNumber());
                System.out.println("Provider Name: " + oPolicy.fGetProvider());
                System.out.println("Policyholder's First Name: " + oPolicy.fGetFirstName());
                System.out.println("Policyholder's Last Name: " + oPolicy.fGetLastName());
                System.out.println("Policyholder's Age: " + oPolicy.fGetAge());

                CPolicy.m_ESmokingStatus ePolicyHolderSmokingStatus = oPolicy.fGetSmokingStatus();
                if (ePolicyHolderSmokingStatus == CPolicy.m_ESmokingStatus.NON_SMOKER)
                {
                    System.out.println("Policyholder's Smoking Status: non-smoker");
                    iNonSmokers++; /* Increment total number of non-smokers */
                }
                else
                {
                    System.out.println("Policyholder's Smoking Status: smoker");
                    iSmokers++; /* Increment total number of smokers. */
                }

                System.out.println("Policyholder's Height: " + String.format("%,.1f", oPolicy.fGetHeightInches()) + " inches");
                System.out.println("Policyholder's Weight: " + String.format("%,.1f", oPolicy.fGetWeightPounds()) + " pounds");
                System.out.println("Policyholder's BMI: " + String.format("%,.2f", oPolicy.fCalculateBMI()));
                System.out.println("Policy Price: $" + String.format("%,.2f", oPolicy.fCalculatePolicyPrice()) + "\n");
            }

            /* Print the nnuber of policyholders that are smokers and the amount that are non-smokers. */
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