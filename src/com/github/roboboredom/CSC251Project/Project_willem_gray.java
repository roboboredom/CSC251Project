package com.github.roboboredom.CSC251Project;

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
        System.out.println("roark roark roark roark roark!!!!!!!!!!!!!!!");

        CPolicy oTestPolicy = new CPolicy(123123123, "Maned Wolf Insurance Corp", "Jane", "Doe", 67, CPolicy.m_ESmokingStatus.SMOKER, 25000000.323, 2939393.339);
        System.out.println("oTestPolicy.fCalculateInsurancePolicyPrice() = " + oTestPolicy.fCalculateInsurancePolicyPrice()); 
        System.out.println("oTestPolicy.fCalculatePolicyHolderBMI() = " + oTestPolicy.fCalculatePolicyHolderBMI()); 
    }
}