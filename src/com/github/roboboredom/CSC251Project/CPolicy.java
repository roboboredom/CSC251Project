package com.github.roboboredom.CSC251Project;

/** Models an insurance policy for one person.
    @author Willem Dawson Gray                 */
public class CPolicy
{
    /* ========================= FINAL FIELDS ========================= */
    /** Base policy fee. */
    private static final double F_dBASE_FEE = 600.0;

    /** Extra policy smoker fee. */
    private static final double F_dSMOKER_FEE = 100.0;

    /** Extra policy age fee. */
    private static final double F_dAGE_FEE = 75.0;

    /** Age threshold above which to apply the extra policy age fee. */
    private static final int F_iAGE_FEE_THRESHOLD = 50;

    /** Extra policy BMI fee multiplier. Used in the BMI fee formula. */
    private static final double F_dBMI_FEE_MULTIPLIER = 20.0;

    /** BMI threshold above which to apply the extra policy BMI fee. */
    private static final double F_dBMI_FEE_THRESHOLD = 35.0;

    /* ========================= FIELDS ========================= */
    /** Policy holder. */ 
    private CPolicyHolder m_oPolicyHolder;

    /** Policy ID. */
    private int m_iPolicy;

    /** Name of the insurance company providing the policy. */
    private String m_sProvider;

    /* ========================= CONSTRUCTOR METHODS ========================= */
    /** Instantiate a new policy object with defaults. */
    public CPolicy()
    {
        m_oPolicyHolder = new CPolicyHolder();
        m_iPolicy       = 0;
        m_sProvider     = "Default Provider";
    }

    /** Instantiate a new policy object.
        @param oPolicyHolder Policy holder.
        @param iPolicy       ID of the policy.
        @param sProvider     Name of the insurance company providing the policy. Argument deep copied for security. */
    public CPolicy
    (
        CPolicyHolder oPolicyHolder,
        int           iPolicy,
        String        sProvider
    )
    {
        /* Make a deep copy of the argument for security. */
        m_oPolicyHolder = new CPolicyHolder
        (
            oPolicyHolder.fGetSmokingStatus(),
            oPolicyHolder.fGetAge(),
            oPolicyHolder.fGetHeightInches(),
            oPolicyHolder.fGetWeightPounds(),
            oPolicyHolder.fGetFirstName(),
            oPolicyHolder.fGetLastName()
        );
        m_iPolicy   = iPolicy;
        m_sProvider = sProvider;
    }

    /* ========================= ACCESSOR METHODS ========================= */
    /** Get a deep copy of the policy holder.
        @return A deep copy of the policy holder. */
    public CPolicyHolder fGetPolicyHolder() 
    { 
        return new CPolicyHolder
        (
            m_oPolicyHolder.fGetSmokingStatus(),
            m_oPolicyHolder.fGetAge(),
            m_oPolicyHolder.fGetHeightInches(),
            m_oPolicyHolder.fGetWeightPounds(),
            m_oPolicyHolder.fGetFirstName(),
            m_oPolicyHolder.fGetLastName()
        );
    }

    /** Gets the ID of the policy.
        @return The ID of the policy. */
    public int fGetPolicyNumber() { return m_iPolicy; }

    /** Gets the name of the insurance company providing the policy.
        @return The name of the insurance company providing the policy. */
    public String fGetProvider() { return m_sProvider; }

    /* ========================= MUTATOR METHODS ========================= */
    /** Sets the policy holder. Argument deep copied for security.
        @param oPolicyHolder Policy holder.                        */
    public void fSetPolicyHolder(CPolicyHolder oPolicyHolder) 
    { 
        m_oPolicyHolder = new CPolicyHolder
        (
            oPolicyHolder.fGetSmokingStatus(),
            oPolicyHolder.fGetAge(),
            oPolicyHolder.fGetHeightInches(),
            oPolicyHolder.fGetWeightPounds(),
            oPolicyHolder.fGetFirstName(),
            oPolicyHolder.fGetLastName()
        );
    }

    /** Sets the ID of the policy.
        @param iPolicy ID of the policy. */
    public void fSetPolicyNumber(int iPolicy) { m_iPolicy = iPolicy; }

    /** Sets the name of the insurance company providing the policy.
        @param sProvider Name of the insurance company providing the policy. */
    public void fSetProvider(String sProvider) { m_sProvider = sProvider; }

    /* ========================= METHODS ========================= */
    /** Calculates the policy price.
        @return The policy price. */
    public double fCalculatePolicyPrice()
    {
        /* Intialize the price to the base fee. */
        double dPrice = F_dBASE_FEE;

        /* Add the age fee if the policy holder's age is greater than the age fee threshold. */
        if (m_oPolicyHolder.fGetAge() > F_iAGE_FEE_THRESHOLD)
        {
            dPrice += F_dAGE_FEE;
        }

        /* Add the smoker fee if the policy holder is a smoker. */
        if (m_oPolicyHolder.fGetSmokingStatus() == CPolicyHolder.m_ESmokingStatus.SMOKER)
        {
            dPrice += F_dSMOKER_FEE;
        }

        /* Calculate and add the BMI fee if the policy holder's BMI is greater than the BMI fee threshold. */
        double dBMI = m_oPolicyHolder.fCalculateBMI();
        if (dBMI > F_dBMI_FEE_THRESHOLD)
        {
            dPrice += (dBMI - F_dBMI_FEE_THRESHOLD) * F_dBMI_FEE_MULTIPLIER;
        }

        return dPrice;
    }

    /** Returns a string with info about the policy.
        @return A string with info about the policy. */
    public String toString()
    {
        return "Policy Number: " + m_iPolicy + "\n" +
               "Provider Name: " + m_sProvider;
    }
}