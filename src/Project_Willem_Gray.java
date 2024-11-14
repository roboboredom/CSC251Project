import java.util.Scanner;

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
        /* Initialize a scanner and also a new policy object. */
        Scanner oScanner = new Scanner(System.in);
        Policy oPolicy = new Policy();

        /* Prompt the user to enter the required policy data. */
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
            oPolicy.fSetPolicyHolderSmokingStatus(Policy.m_ESmokingStatus.SMOKER);
        }
        else if (sInput.equals("non-smoker"))
        {
            oPolicy.fSetPolicyHolderSmokingStatus(Policy.m_ESmokingStatus.NON_SMOKER);
        }

        System.out.print("Please enter the Policyholder's Height (in inches): ");
        oPolicy.fSetPolicyHolderHeightInches(oScanner.nextDouble());
        oScanner.nextLine();

        System.out.print("Please enter the Policyholder's Weight (in pounds): ");
        oPolicy.fSetPolicyHolderWeightPounds(oScanner.nextDouble());
        oScanner.nextLine();

        /* Print out all the entered data. */
        System.out.println("\nPolicy Number: " + oPolicy.fGetPolicyNumber());
        System.out.println("Provider Name: " + oPolicy.fGetProviderName());
        System.out.println("Policyholder's First Name: " + oPolicy.fGetPolicyHolderFirstName());
        System.out.println("Policyholder's Last Name: " + oPolicy.fGetPolicyHolderLastName());
        System.out.println("Policyholder's Age: " + oPolicy.fGetPolicyHolderAge());

        Policy.m_ESmokingStatus ePolicyHolderSmokingStatus = oPolicy.fGetPolicyHolderSmokingStatus();
        if (ePolicyHolderSmokingStatus == Policy.m_ESmokingStatus.NON_SMOKER)
        {
            System.out.println("Policyholder's Smoking Status: non-smoker");
        }
        else
        {
            System.out.println("Policyholder's Smoking Status: smoker");
        }

        System.out.println("Policyholder's Height: " + String.format("%.1f", oPolicy.fGetPolicyHolderHeightInches()) + " inches");
        System.out.println("Policyholder's Weight: " + String.format("%.1f", oPolicy.fGetPolicyHolderWeightPounds()) + " pounds");

        /* Run the needed calculations and print out the BMI and total insurance policy price. */
        System.out.println("Policyholder's BMI: " + String.format("%.2f", oPolicy.fCalculatePolicyHolderBMI()));
        System.out.println("Policy Price: $" + String.format("%.2f", oPolicy.fCalculateInsurancePolicyPrice()));

        /* Close the scanner to prevent a resource leak. */
        oScanner.close();
    }
}