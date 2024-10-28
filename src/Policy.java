/**
 * Models an insurance policy for one person.
 * <ul>
 *     <li>An instance of this class holds an insurance policy for one person
 *     </li>
 * </ul>
 * 
 * @author Willem Dawson Gray
 */
public class Policy
{
    /** Base insurance policy fee */
    private static final double F_dINSURANCE_POLICY_BASE_FEE = 600.0;

    /** Additional insurance policy smoker fee */
    private static final double F_dINSURANCE_POLICY_SMOKER_FEE = 100.0;

    /** Additional insurance policy age fee */
    private static final double F_dINSURANCE_POLICY_AGE_FEE = 75.0;

    /** Age threshold above which to apply the additional insurance policy age fee */
    private static final int F_iINSURANCE_POLICY_AGE_FEE_THRESHOLD = 50;

    /** Additional insurance policy BMI fee multipler. Used in the BMI fee formula */
    private static final double F_dINSURANCE_POLICY_BMI_FEE_MULTIPLIER = 20.0;

    /** BMI threshold above which to apply the additional insurance policy BMI fee */
    private static final double F_dINSURANCE_POLICY_BMI_FEE_THRESHOLD = 35.0;


    /** Available policy holder smoking statuses */
    public enum m_ESmokingStatus 
    { 
        /** The policy holder smokes */
        SMOKER, 
        
        /** The policy holder doesn't smoke */
        NON_SMOKER 
    }


    /** ID of the insurance policy */
    private int m_iPolicyNumber;

    /** Name of the insurance company providing the policy to the holder */
    private String m_sProviderName;

    /** Policy holder's first name */
    private String m_sPolicyHolderFirstName;

    /** Policy holder's last name */
    private String m_sPolicyHolderLastName;

    /** Policy holder's age */
    private int m_iPolicyHolderAge;

    /** Policy holder's smoking status.
     * <ul>
     *     <li>See {@link m_ESmokingStatus} for possible states.
     *     </li>
     * </ul>
     */
    private m_ESmokingStatus m_ePolicyHolderSmokingStatus;

    /** Policy holder's height, in inches */
    private double m_dPolicyHolderHeightInches;

    /** Policy holder's weight, in pounds */
    private double m_dPolicyHolderWeightPounds;


    /** Instantiate a new insurance policy object with defaults */
    public Policy()
    {
        m_iPolicyNumber = 0;
        m_sProviderName = "Default Provider";
        m_sPolicyHolderFirstName = "Default First Name";
        m_sPolicyHolderLastName = "Default Last Name";
        m_iPolicyHolderAge = 0;
        m_ePolicyHolderSmokingStatus = m_ESmokingStatus.NON_SMOKER;
        m_dPolicyHolderHeightInches = 0.0;
        m_dPolicyHolderWeightPounds = 0.0;
    }

    /** Instantiate a new insurance policy object.
     * @param iPolicyNumber ID of the insurance policy
     * @param sProviderName Name of the insurance company providing the policy to the holder
     * @param sPolicyHolderFirstName Policy holder's first name
     * @param sPolicyHolderLastName Policy holder's last name
     * @param iPolicyHolderAge Policy holder's age
     * @param ePolicyHolderSmokingStatus Policy holder smoking status.
     * <ul>
     *     <li>See {@link m_ESmokingStatus} for possible states.
     *     </li>
     * </ul>
     * @param dPolicyHolderHeightInches Policy holder height, in inches
     * @param dPolicyHolderWeightPounds Policy holder weight, in pounds
     */
    public Policy
    (
        int iPolicyNumber,
        String sProviderName,
        String sPolicyHolderFirstName,
        String sPolicyHolderLastName,
        int iPolicyHolderAge,
        m_ESmokingStatus ePolicyHolderSmokingStatus,
        double dPolicyHolderHeightInches,
        double dPolicyHolderWeightPounds
    )
    {
        m_iPolicyNumber = iPolicyNumber;
        m_sProviderName = sProviderName;
        m_sPolicyHolderFirstName = sPolicyHolderFirstName;
        m_sPolicyHolderLastName = sPolicyHolderLastName;
        m_iPolicyHolderAge = iPolicyHolderAge;
        m_ePolicyHolderSmokingStatus = ePolicyHolderSmokingStatus;
        m_dPolicyHolderHeightInches = dPolicyHolderHeightInches;
        m_dPolicyHolderWeightPounds = dPolicyHolderWeightPounds;
    }
    
    
    /** Sets the ID of the insurance policy.
     * @param iPolicyNumber ID of the insurance policy
     */
    public void fSetPolicyNumber(int iPolicyNumber) { m_iPolicyNumber = iPolicyNumber; }

    /** Sets the name of the insurance company providing the policy to the holder.
     * @param sProviderName Name of the insurance company providing the policy to the holder
     */
    public void fSetProviderName(String sProviderName) { m_sProviderName = sProviderName; }

    /** Sets the policy holder's first name.
     * @param sPolicyHolderFirstName Policy holder's first name
     */
    public void fSetPolicyHolderFirstName(String sPolicyHolderFirstName) { m_sPolicyHolderFirstName = sPolicyHolderFirstName; }

    /** Sets the policy holder's last name.
     * @param sPolicyHolderLastName Policy holder's last name
     */
    public void fSetPolicyHolderLastName(String sPolicyHolderLastName) { m_sPolicyHolderLastName = sPolicyHolderLastName; }

    /** Sets the policy holder's age.
     * @param iPolicyHolderAge Policy holder's age
     */
    public void fSetPolicyHolderAge(int iPolicyHolderAge) { m_iPolicyHolderAge = iPolicyHolderAge; }

    /** Sets the policy holder's smoking status.
     * @param eSmokingStatus Policy holder's smoking status
     */
    public void fSetPolicyHolderSmokingStatus(m_ESmokingStatus eSmokingStatus) { m_ePolicyHolderSmokingStatus = eSmokingStatus; }

    /** Sets the policy holder's height, in inches.
     * @param dPolicyHolderHeightInches Policy holder's height, in inches
     */
    public void fSetPolicyHolderHeightInches(double dPolicyHolderHeightInches) { m_dPolicyHolderHeightInches = dPolicyHolderHeightInches; }

    /** Sets the policy holder's weight, in pounds.
     * @param dPolicyHolderWeightPounds Policy holder's weight, in pounds
     */
    public void fSetPolicyHolderWeightPounds(double dPolicyHolderWeightPounds) { m_dPolicyHolderWeightPounds = dPolicyHolderWeightPounds; }


    /** Gets the ID of the insurance policy.
     * @return The ID of the insurance policy
     */
    public int fGetPolicyNumber() { return m_iPolicyNumber; }

    /** Gets the name of the insurance company providing the policy to the holder.
     * @return The name of the insurance company providing the policy to the holder
     */
    public String fGetProviderName() { return m_sProviderName; }

    /** Gets the policy holder's first name.
     * @return The policy holder's first name
     */
    public String fGetPolicyHolderFirstName() { return m_sPolicyHolderFirstName; }

    /** Gets the policy holder's last name.
     * @return The policy holder's last name
     */
    public String fGetPolicyHolderLastName() { return m_sPolicyHolderLastName; }

    /** Gets the policy holder's age.
     * @return The policy holder's age
     */
    public int fGetPolicyHolderAge() { return m_iPolicyHolderAge; }

    /** Gets the policy holder's smoking status.
     * @return The policy holder's smoking status
     */
    public m_ESmokingStatus fGetPolicyHolderSmokingStatus() { return m_ePolicyHolderSmokingStatus; }

    /** Gets the policy holder's height, in inches.
     * @return The policy holder's height, in inches
     */
    public double fGetPolicyHolderHeightInches() { return m_dPolicyHolderHeightInches; }

    /** Gets the policy holder's weight, in pounds.
     * @return The policy holder's weight, in pounds
     */
    public double fGetPolicyHolderWeightPounds() { return m_dPolicyHolderWeightPounds; }


    /** 
     * Calculates the policy holder's BMI.
     * <ul>
     *     <li>The formula is 
     *         <pre><code>(m_dPolicyHolderWeightPounds * 703.0) / (Math.pow(m_dPolicyHolderHeightInches, 2.0))
     *         </code></pre>
     *     </li>
     * </ul>
     * 
     * @return The BMI of the policy holder
     */
    public double fCalculatePolicyHolderBMI()
    {
        /* Calculate the policy holder's BMI */
        return (m_dPolicyHolderWeightPounds * 703.0) / (Math.pow(m_dPolicyHolderHeightInches, 2.0));
    }

    /** 
     * Calculates the policy holder's insurance policy price.
     * <ul>
     *     <li>The base fee is {@link #F_dINSURANCE_POLICY_BASE_FEE}
     *     </li>
     *     <li>If the policyholder's age is greater than {@link #F_iINSURANCE_POLICY_AGE_FEE_THRESHOLD}, there is an added fee of {@link #F_dINSURANCE_POLICY_AGE_FEE}
     *     </li>
     *     <li>If the policyholder is a smoker, there is an added fee of {@link #F_dINSURANCE_POLICY_SMOKER_FEE}
     *     </li>
     *     <li>If the policyholder's BMI is greater than {@link #F_dINSURANCE_POLICY_BMI_FEE_THRESHOLD}, there is an added fee using the formula
     *         <pre><code>(dPolicyHolderBMI - F_dINSURANCE_POLICY_BMI_FEE_THRESHOLD) * F_dINSURANCE_POLICY_BMI_FEE_MULTIPLIER
     *         </code></pre>
     *     </li>
     * </ul>
     * 
     * @return The the policy holder's insurance policy price
     */
    public double fCalculateInsurancePolicyPrice()
    {
        /* Intialize the price to the base fee */
        double dInsurancePolicyPrice = F_dINSURANCE_POLICY_BASE_FEE;

        /* Add the age fee if the policy holder's age is greater than the age fee threshold */
        if (m_iPolicyHolderAge > F_iINSURANCE_POLICY_AGE_FEE_THRESHOLD)
        {
            dInsurancePolicyPrice += F_dINSURANCE_POLICY_AGE_FEE;
        }

        /* Add the smoker fee if the policy holder is a smoker */
        if (m_ePolicyHolderSmokingStatus == m_ESmokingStatus.SMOKER)
        {
            dInsurancePolicyPrice += F_dINSURANCE_POLICY_SMOKER_FEE;
        }

        /* Calculate and add the BMI fee if the policy holder's BMI is greater than the BMI fee threshold */
        double dPolicyHolderBMI = fCalculatePolicyHolderBMI();
        if (dPolicyHolderBMI > F_dINSURANCE_POLICY_BMI_FEE_THRESHOLD) 
        {
            dInsurancePolicyPrice += (dPolicyHolderBMI - F_dINSURANCE_POLICY_BMI_FEE_THRESHOLD) * F_dINSURANCE_POLICY_BMI_FEE_MULTIPLIER;
        }

        return dInsurancePolicyPrice;
    }
}