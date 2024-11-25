package com.github.roboboredom.CSC251Project;

/** Models an insurance policy holder.
    @author Willem Dawson Gray         */
public class CPolicyHolder
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

    /* ========================= FIELDS ========================= */
    /** Policy holder's smoking status.
        <ul>
            <li>See {@link m_ESmokingStatus} for possible states.</li>
        </ul>                                                          */
    private m_ESmokingStatus m_eSmokingStatus;

    /** Policy holder's age. */
    private int m_iAge;

    /** Policy holder's height, in inches. */
    private double m_dHeightInches;

    /** Policy holder's weight, in pounds. */
    private double m_dWeightPounds;

    /** Policy holder's first name. */
    private String m_sFirstName;

    /** Policy holder's last name. */
    private String m_sLastName;

    /* ========================= CONSTRUCTOR METHODS ========================= */
    /** Instantiate a new insurance policy object with defaults. */
    public CPolicyHolder()
    {
        m_eSmokingStatus = m_ESmokingStatus.NON_SMOKER;
        m_iAge           = 0;
        m_dHeightInches  = 0.0;
        m_dWeightPounds  = 0.0;
        m_sFirstName     = "Default First Name";
        m_sLastName      = "Default Last Name";
    }

    /** Instantiate a new policy holder object.
        @param eSmokingStatus Policy holder smoking status.
        <ul>
            <li>See {@link m_ESmokingStatus} for possible states.</li>
        </ul>
        @param iAge          Policy holder's age.
        @param dHeightInches Policy holder height, in inches.
        @param dWeightPounds Policy holder weight, in pounds.
        @param sFirstName    Policy holder's first name.
        @param sLastName     Policy holder's last name.                */
    public CPolicyHolder
    (
        m_ESmokingStatus eSmokingStatus,
        int              iAge,
        double           dHeightInches,
        double           dWeightPounds,
        String           sFirstName,
        String           sLastName
    )
    {
        m_eSmokingStatus = eSmokingStatus;
        m_iAge           = iAge;
        m_dHeightInches  = dHeightInches;
        m_dWeightPounds  = dWeightPounds;
        m_sFirstName     = sFirstName;
        m_sLastName      = sLastName;
    }

    /* ========================= ACCESSOR METHODS ========================= */
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

    /** Returns a string with info about the policy holder.
    @return A string with info about the policy holder.     */
    public String toString()
    {
        String sSmokingStatus = "non-smoker";
        if (m_eSmokingStatus == m_ESmokingStatus.SMOKER) { sSmokingStatus = "smoker"; }

        return "Policyholder's First Name: " + m_sFirstName + "\n" +
               "Policyholder's Last Name: " + m_sLastName + "\n" +
               "Policyholder's Age: " + m_iAge + "\n" +
               "Policyholder's Smoking Status (Y/N): " + sSmokingStatus + "\n" +
               "Policyholder's Height: " + String.format("%,.1f", m_dHeightInches) + " inches\n" +
               "Policyholder's Weight: " + String.format("%,.1f", m_dWeightPounds) + " pounds\n" +
               "Policyholder's BMI: " + String.format("%,.2f", fCalculateBMI());
    }
}