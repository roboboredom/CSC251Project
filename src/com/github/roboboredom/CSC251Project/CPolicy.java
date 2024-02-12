package com.github.roboboredom.CSC251Project;



class CPolicy
{
     /* Private member variables */
    final double F_dINSURANCE_POLICY_BASE_FEE = 600.0D;
    final double F_dINSURANCE_POLICY_SMOKER_FEE = 100.0D;
    final double F_dINSURANCE_POLICY_AGE_FEE = 75.0D;
    final int F_iINSURANCE_POLICY_AGE_FEE_THRESHOLD = 50;
    final double F_dINSURANCE_POLICY_BMI_FEE_THRESHOLD = 35.0D;
    final double F_dINSURANCE_POLICY_BMI_FEE_MULTIPLIER = 20.0D;

    enum m_ESmokingStatus { SMOKER, NON_SMOKER }
    
    int m_iPolicyNumber;
    String m_sProviderName;
    String m_sPolicyHolderFirstName;
    String m_sPolicyHolderLastName;
    int m_iPolicyHolderAge;
    m_ESmokingStatus m_ePolicyHolderSmokingStatus;
    double m_dPolicyHolderHeightInches;
    double m_dPolicyHolderWeightPounds;

    /* Constructors: */
    CPolicy()
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

    CPolicy
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
    
    /* Setter methods for private member variables: */
    void fSetPolicyNumber(int iPolicyNumber) { m_iPolicyNumber = iPolicyNumber; }
    void fSetProviderName(String sProviderName) { m_sProviderName = sProviderName; }
    void fSetPolicyHolderFirstName(String sPolicyHolderFirstName) { m_sPolicyHolderFirstName = sPolicyHolderFirstName; }
    void fSetPolicyHolderLastName(String sPolicyHolderLastName) { m_sPolicyHolderLastName = sPolicyHolderLastName; }
    void fSetPolicyHolderAge(int iPolicyHolderAge) { m_iPolicyHolderAge = iPolicyHolderAge; }
    void fSetPolicyHolderSmokingStatus(m_ESmokingStatus eSmokingStatus) { m_ePolicyHolderSmokingStatus = eSmokingStatus; }
    void fSetPolicyHolderHeightInches(double dPolicyHolderHeightInches) { m_dPolicyHolderHeightInches = dPolicyHolderHeightInches; }
    void fSetPolicyHolderWeightPounds(double dPolicyHolderWeightPounds) { m_dPolicyHolderWeightPounds = dPolicyHolderWeightPounds; }

    /* Getter methods for private member variables: */
    int fGetPolicyNumber() { return m_iPolicyNumber; }
    String fGetProviderName() { return m_sProviderName; }
    String fGetPolicyHolderFirstName() { return m_sPolicyHolderFirstName; }
    String fGetPolicyHolderLastName() { return m_sPolicyHolderLastName; }
    int fGetPolicyHolderAge() { return m_iPolicyHolderAge; }
    m_ESmokingStatus fGetPolicyHolderSmokingStatus() { return m_ePolicyHolderSmokingStatus; }
    double fGetPolicyHolderHeightInches() { return m_dPolicyHolderHeightInches; }
    double fGetPolicyHolderWeightPounds() { return m_dPolicyHolderWeightPounds; }

    /* Methods: */
    double fCalculatePolicyHolderBMI()
    {
        /* Calculate the policy holder's BMI */
        return m_dPolicyHolderWeightPounds * 703.0D / Math.pow(m_dPolicyHolderHeightInches, 2.0D);
    }

    double fCalculateInsurancePolicyPrice()
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