import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Demo / driver class for Policy class.
 * <ul>
 *     <li>This class contains the main method.
 *     </li>
 * </ul>
 * 
 * @author Willem Dawson Gray
 */
public class Project_Willem_Gray
{
    /** Program entrypoint. 
     * @param a_sArgs Command line arguments to the program.
    */
    public static void main(String[] a_sArgs)
    {
        /* Initialize two int vars to count the number of policyholders that are smokers and that are non-smokers. */
        int iSmokers = 0, iNonSmokers = 0;
        
        try 
        {
            /* Initialize a scanner to read from the PolicyInformation.txt file. */
            Scanner oScanner = new Scanner(new File(".." + File.separator + "res" + File.separator + "PolicyInformation.txt"));
           
            /* Intialize an arraylist to store all the needed policy objects. */
            ArrayList<Policy> al_oPolicies = new ArrayList<Policy>();
           
            /* Iterate through the file and populate the arraylist with policy objects constructed with the data in the file. */
            while(oScanner.hasNext())
            {
                Policy oPolicy = new Policy();
                
                /* Scan in the data in the file to the policy object. */
                oPolicy.fSetPolicyNumber(Integer.parseInt(oScanner.nextLine()));
                
                oPolicy.fSetProviderName(oScanner.nextLine());
                oPolicy.fSetPolicyHolderFirstName(oScanner.nextLine());
                oPolicy.fSetPolicyHolderLastName(oScanner.nextLine());
                
                oPolicy.fSetPolicyHolderAge(Integer.parseInt(oScanner.nextLine()));
        
                String sInput = oScanner.nextLine();
                if (sInput.equals("smoker"))
                {
                    oPolicy.fSetPolicyHolderSmokingStatus(Policy.m_ESmokingStatus.SMOKER);
                }
                else if (sInput.equals("non-smoker"))
                {
                    oPolicy.fSetPolicyHolderSmokingStatus(Policy.m_ESmokingStatus.NON_SMOKER);
                }
        
                oPolicy.fSetPolicyHolderHeightInches(Double.parseDouble(oScanner.nextLine()));
                oPolicy.fSetPolicyHolderWeightPounds(Double.parseDouble(oScanner.nextLine()));
                
                /* Consume the blank line exists after each policy object's data, if it exists. */
                if (oScanner.hasNext()) { oScanner.nextLine(); }
                
                /* Add the policy to the arraylist. */
                al_oPolicies.add(oPolicy);
            }
            
            /* Iterate through all the policy objects in the array and print the data for each. */
            for (Policy oPolicy : al_oPolicies)
            {
                System.out.println("Policy Number: " + oPolicy.fGetPolicyNumber());
                System.out.println("Provider Name: " + oPolicy.fGetProviderName());
                System.out.println("Policyholder's First Name: " + oPolicy.fGetPolicyHolderFirstName());
                System.out.println("Policyholder's Last Name: " + oPolicy.fGetPolicyHolderLastName());
                System.out.println("Policyholder's Age: " + oPolicy.fGetPolicyHolderAge());
        
                Policy.m_ESmokingStatus ePolicyHolderSmokingStatus = oPolicy.fGetPolicyHolderSmokingStatus();
                if (ePolicyHolderSmokingStatus == Policy.m_ESmokingStatus.NON_SMOKER)
                {
                    System.out.println("Policyholder's Smoking Status: non-smoker");
                    iNonSmokers++; /* Increment total number of non-smokers */
                }
                else
                {
                    System.out.println("Policyholder's Smoking Status: smoker");
                    iSmokers++; /* Increment total number of smokers. */
                }
        
                System.out.println("Policyholder's Height: " + String.format("%.1f", oPolicy.fGetPolicyHolderHeightInches()) + " inches");
                System.out.println("Policyholder's Weight: " + String.format("%.1f", oPolicy.fGetPolicyHolderWeightPounds()) + " pounds");
                System.out.println("Policyholder's BMI: " + String.format("%.2f", oPolicy.fCalculatePolicyHolderBMI()));
                System.out.println("Policy Price: $" + String.format("%.2f", oPolicy.fCalculateInsurancePolicyPrice()) + "\n");
            }
            
            /* Print the nnuber of policyholders that are smokers and the amount that are non-smokers. */
            System.out.println("The number of policies with a smoker is: " + iSmokers);
            System.out.println("The number of policies with a non-smoker is: " + iNonSmokers);
    
            /* Close the scanner to prevent a resource leak. */
            oScanner.close();
        }
        catch (IOException e)
        {
            System.out.println("[ERROR] Something went wrong reading the file \"../res/PolicyInformation.txt\".");
        }
    }
}