package com.github.roboboredom.CSC251Project;

public class CPolicy
{
    /** Base insurance policy fee. */
    private static final double F_dINSURANCE_POLICY_BASE_FEE = 600.0D;

    /** Additional insurance policy smoker fee. */
    private static final double F_dINSURANCE_POLICY_SMOKER_FEE = 100.0D;

    /** Additional insurance policy age fee. */
    private static final double F_dINSURANCE_POLICY_AGE_FEE = 75.0D;

    /** Age threshold above which to apply the additional insurance policy age fee. */
    private static final int F_iINSURANCE_POLICY_AGE_FEE_THRESHOLD = 50;

    /** Additional insurance policy BMI fee multipler. Used in the BMI fee formula */
    private static final double F_dINSURANCE_POLICY_BMI_FEE_MULTIPLIER = 20.0D;

    /** BMI threshold above which to apply the additional insurance policy BMI fee. */
    private static final double F_dINSURANCE_POLICY_BMI_FEE_THRESHOLD = 35.0D;


    /** Available policy holder smoking statuses. */
    public static enum m_ESmokingStatus { SMOKER, NON_SMOKER }

    /** ID of the insurance policy. */
    private int m_iPolicyNumber;

    /** Name of the insurance company providing the policy to the holder. */
    private String m_sProviderName;

    /** Policy holder's first name */
    private String m_sPolicyHolderFirstName;

    /** Policy holder's last name */
    private String m_sPolicyHolderLastName;

    /** Policy holder's age */
    private int m_iPolicyHolderAge;

    /** Policy holder smoking status. 
     * <p><ul>
     *     <li>See {@link #m_ESmokingStatus} for possible states.
     *     </li>
     * </ul></p>
     */
    private m_ESmokingStatus m_ePolicyHolderSmokingStatus;

    /** Policy holder height, in inches. */
    private double m_dPolicyHolderHeightInches;

    /** Policy holder weight, in pounds. */
    private double m_dPolicyHolderWeightPounds;


    public CPolicy()
    {
        m_iPolicyNumber = 0;
        m_sProviderName = "Example Provider";
        m_sPolicyHolderFirstName = "Example First Name";
        m_sPolicyHolderLastName = "Example Last Name";
        m_iPolicyHolderAge = 0;
        m_ePolicyHolderSmokingStatus = m_ESmokingStatus.NON_SMOKER;
        m_dPolicyHolderHeightInches = 0.0D;
        m_dPolicyHolderWeightPounds = 0.0D;
    }

    public CPolicy
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
    

    public void fSetPolicyNumber(int iPolicyNumber) { m_iPolicyNumber = iPolicyNumber; }
    public void fSetProviderName(String sProviderName) { m_sProviderName = sProviderName; }
    public void fSetPolicyHolderFirstName(String sPolicyHolderFirstName) { m_sPolicyHolderFirstName = sPolicyHolderFirstName; }
    public void fSetPolicyHolderLastName(String sPolicyHolderLastName) { m_sPolicyHolderLastName = sPolicyHolderLastName; }
    public void fSetPolicyHolderAge(int iPolicyHolderAge) { m_iPolicyHolderAge = iPolicyHolderAge; }
    public void fSetPolicyHolderSmokingStatus(m_ESmokingStatus eSmokingStatus) { m_ePolicyHolderSmokingStatus = eSmokingStatus; }
    public void fSetPolicyHolderHeightInches(double dPolicyHolderHeightInches) { m_dPolicyHolderHeightInches = dPolicyHolderHeightInches; }
    public void fSetPolicyHolderWeightPounds(double dPolicyHolderWeightPounds) { m_dPolicyHolderWeightPounds = dPolicyHolderWeightPounds; }

    public int fGetPolicyNumber() { return m_iPolicyNumber; }
    public String fGetProviderName() { return m_sProviderName; }
    public String fGetPolicyHolderFirstName() { return m_sPolicyHolderFirstName; }
    public String fGetPolicyHolderLastName() { return m_sPolicyHolderLastName; }
    public int fGetPolicyHolderAge() { return m_iPolicyHolderAge; }
    public m_ESmokingStatus fGetPolicyHolderSmokingStatus() { return m_ePolicyHolderSmokingStatus; }
    public double fGetPolicyHolderHeightInches() { return m_dPolicyHolderHeightInches; }
    public double fGetPolicyHolderWeightPounds() { return m_dPolicyHolderWeightPounds; }

    
    /** 
     * Calculates the policy holder's BMI.
     * <p><ul>
     *     <li>The formula is 
     *         <pre><code>m_dPolicyHolderWeightPounds * 703.0D / Math.pow(m_dPolicyHolderHeightInches, 2.0D)
     *         </code></pre>
     *     </li>
     * </ul></p>
     * 
     * @return The BMI of the policy holder.
     */
    public double fCalculatePolicyHolderBMI()
    {
        /* Calculate the policy holder's BMI */
        return m_dPolicyHolderWeightPounds * 703.0D / Math.pow(m_dPolicyHolderHeightInches, 2.0D);
    }

    /** 
     * Calculates the policy holder's insurance policy price.
     * <p><ul>
     *     <li>The base fee is {@link #F_dINSURANCE_POLICY_BASE_FEE}.
     *     </li>
     *     <li>If the policyholder's age is greater than {@link #F_iINSURANCE_POLICY_AGE_FEE_THRESHOLD}, there is an added fee of {@link #F_dINSURANCE_POLICY_AGE_FEE}.
     *     </li>
     *     <li>If the policyholder is a smoker, there is an added fee of {@link #F_dINSURANCE_POLICY_SMOKER_FEE}.
     *     </li>
     *     <li>If the policyholder's BMI is greater than {@link #F_dINSURANCE_POLICY_BMI_FEE_THRESHOLD}, there is an added fee using the formula
     *         <pre><code>(dPolicyHolderBMI - F_dINSURANCE_POLICY_BMI_FEE_THRESHOLD) * F_dINSURANCE_POLICY_BMI_FEE_MULTIPLIER
     *         </code></pre>
     *     </li>
     * </ul></p>
     * 
     * @return The the policy holder's insurance policy price.
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