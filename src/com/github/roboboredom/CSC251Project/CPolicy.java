package com.github.roboboredom.CSC251Project;

/** Models an insurance policy for one person.
    @author Willem Dawson Gray                 */
public class CPolicy
{
    /* ========================= NESTED CLASSES ========================= */
    /** Available policy holder smoking statuses. */
    public enum m_ESmokingStatus
    {
        /** The policy holder smokes. */
        SMOKER,

        /** The policy holder doesn't smoke. */
        NON_SMOKER
    }

    /* ========================= FINAL FIELDS ========================= */
    /** Base insurance policy fee. */
    private static final double F_dBASE_FEE = 600.0;

    /** Additional insurance policy smoker fee. */
    private static final double F_dSMOKER_FEE = 100.0;

    /** Additional insurance policy age fee. */
    private static final double F_dAGE_FEE = 75.0;

    /** Age threshold above which to apply the additional insurance policy age fee. */
    private static final int F_iAGE_FEE_THRESHOLD = 50;

    /** Additional insurance policy BMI fee multipler. Used in the BMI fee formula. */
    private static final double F_dBMI_FEE_MULTIPLIER = 20.0;

    /** BMI threshold above which to apply the additional insurance policy BMI fee. */
    private static final double F_dBMI_FEE_THRESHOLD = 35.0;

    /* ========================= FIELDS ========================= */
    /** Policy holder's smoking status.
        <ul>
            <li>See {@link m_ESmokingStatus} for possible states.</li>
        </ul>                                                          */
    private m_ESmokingStatus m_eSmokingStatus;

    /** Policy holder's age. */
    private int m_iAge;

    /** ID of the insurance policy. */
    private int m_iPolicy;

    /** Policy holder's height, in inches. */
    private double m_dHeightInches;

    /** Policy holder's weight, in pounds. */
    private double m_dWeightPounds;

    /** Name of the insurance company providing the policy to the holder. */
    private String m_sProvider;

    /** Policy holder's first name. */
    private String m_sFirstName;

    /** Policy holder's last name. */
    private String m_sLastName;

    /* ========================= CONSTRUCTOR METHODS ========================= */
    /** Instantiate a new insurance policy object with defaults. */
    public CPolicy()
    {
        m_eSmokingStatus = m_ESmokingStatus.NON_SMOKER;
        m_iAge           = 0;
        m_iPolicy        = 0;
        m_dHeightInches  = 0.0;
        m_dWeightPounds  = 0.0;
        m_sProvider      = "Default Provider";
        m_sFirstName     = "Default First Name";
        m_sLastName      = "Default Last Name";
    }

    /** Instantiate a new insurance policy object.
        @param eSmokingStatus Policy holder smoking status.
        <ul>
            <li>See {@link m_ESmokingStatus} for possible states.</li>
        </ul>
        @param iAge           Policy holder's age.
        @param iPolicy        ID of the insurance policy.
        @param dHeightInches  Policy holder height, in inches.
        @param dWeightPounds  Policy holder weight, in pounds.
        @param sProvider      Name of the insurance company providing the policy to the holder.
        @param sFirstName     Policy holder's first name.
        @param sLastName      Policy holder's last name.                                        */
    public CPolicy
    (
        m_ESmokingStatus eSmokingStatus,
        int              iAge,
        int              iPolicy,
        double           dHeightInches,
        double           dWeightPounds,
        String           sProvider,
        String           sFirstName,
        String           sLastName
    )
    {
        m_eSmokingStatus = eSmokingStatus;
        m_iAge           = iAge;
        m_iPolicy        = iPolicy;
        m_dHeightInches  = dHeightInches;
        m_dWeightPounds  = dWeightPounds;
        m_sProvider      = sProvider;
        m_sFirstName     = sFirstName;
        m_sLastName      = sLastName;
    }

    /* ========================= ACCESSOR METHODS ========================= */
    /** Gets the ID of the insurance policy.
        @return The ID of the insurance policy. */
    public int fGetPolicyNumber() { return m_iPolicy; }

    /** Gets the name of the insurance company providing the policy to the holder.
        @return The name of the insurance company providing the policy to the holder. */
    public String fGetProvider() { return m_sProvider; }

    /** Gets the policy holder's first name.
        @return The policy holder's first name. */
    public String fGetFirstName() { return m_sFirstName; }

    /** Gets the policy holder's last name.
        @return The policy holder's last name. */
    public String fGetLastName() { return m_sLastName; }

    /** Gets the policy holder's age.
        @return The policy holder's age. */
    public int fGetAge() { return m_iAge; }

    /** Gets the policy holder's smoking status.
        @return The policy holder's smoking status. */
    public m_ESmokingStatus fGetSmokingStatus() { return m_eSmokingStatus; }

    /** Gets the policy holder's height, in inches.
        @return The policy holder's height, in inches. */
    public double fGetHeightInches() { return m_dHeightInches; }

    /** Gets the policy holder's weight, in pounds.
        @return The policy holder's weight, in pounds. */
    public double fGetWeightPounds() { return m_dWeightPounds; }

    /* ========================= MUTATOR METHODS ========================= */
    /** Sets the ID of the insurance policy.
        @param iPolicy ID of the insurance policy. */
    public void fSetPolicyNumber(int iPolicy) { m_iPolicy = iPolicy; }

    /** Sets the name of the insurance company providing the policy to the holder.
        @param sProvider Name of the insurance company providing the policy to the holder. */
    public void fSetProvider(String sProvider) { m_sProvider = sProvider; }

    /** Sets the policy holder's first name.
        @param sFirstName Policy holder's first name. */
    public void fSetFirstName(String sFirstName) { m_sFirstName = sFirstName; }

    /** Sets the policy holder's last name.
        @param sLastName Policy holder's last name. */
    public void fSetLastName(String sLastName) { m_sLastName = sLastName; }

    /** Sets the policy holder's age.
        @param iAge Policy holder's age. */
    public void fSetAge(int iAge) { m_iAge = iAge; }

    /** Sets the policy holder's smoking status.
        @param eSmokingStatus Policy holder's smoking status. */
    public void fSetSmokingStatus(m_ESmokingStatus eSmokingStatus) { m_eSmokingStatus = eSmokingStatus; }

    /** Sets the policy holder's height, in inches.
        @param dHeightInches Policy holder's height, in inches. */
    public void fSetHeightInches(double dHeightInches) { m_dHeightInches = dHeightInches; }

    /** Sets the policy holder's weight, in pounds.
        @param dWeightPounds Policy holder's weight, in pounds. */
    public void fSetWeightPounds(double dWeightPounds) { m_dWeightPounds = dWeightPounds; }

    /* ========================= METHODS ========================= */
    /** Calculates the policy holder's BMI.
        @return The BMI of the policy holder. */
    public double fCalculateBMI()
    {
        /* Calculate the policy holder's BMI. */
        return (m_dWeightPounds * 703.0) / (m_dHeightInches * m_dHeightInches);
    }

    /** Calculates the policy holder's insurance policy price.
        @return The the policy holder's insurance policy price. */
    public double fCalculatePolicyPrice()
    {
        /* Intialize the price to the base fee. */
        double dPrice = F_dBASE_FEE;

        /* Add the age fee if the policy holder's age is greater than the age fee threshold. */
        if (m_iAge > F_iAGE_FEE_THRESHOLD)
        {
            dPrice += F_dAGE_FEE;
        }

        /* Add the smoker fee if the policy holder is a smoker. */
        if (m_eSmokingStatus == m_ESmokingStatus.SMOKER)
        {
            dPrice += F_dSMOKER_FEE;
        }

        /* Calculate and add the BMI fee if the policy holder's BMI is greater than the BMI fee threshold. */
        double dBMI = fCalculateBMI();
        if (dBMI > F_dBMI_FEE_THRESHOLD)
        {
            dPrice += (dBMI - F_dBMI_FEE_THRESHOLD) * F_dBMI_FEE_MULTIPLIER;
        }

        return dPrice;
    }
}