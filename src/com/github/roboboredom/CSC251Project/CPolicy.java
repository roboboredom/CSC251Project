package com.github.roboboredom.CSC251Project;

class CPolicy
{
    /* NOTE: This style of naming is an old
     * convention called hungarian notation.
     * It is considered outdated by some because
     * most modern IDEs display type directly,
     * but I prefer it because not only does it prevent
     * name collisions, it allows you to see
     * what type something is outside the IDE without browsing
     * the code directly. It also allows you to "search" autocomplete
     * by typing a prefix. I learned about it from
     * messing around with the source code for Quake, and Source SDK 2013.
     * 
     * An example of a large codebase that makes use of hungarian
     * notation is 
     * 
     * Key for this file:
     *     i   int
     *     d   double
     *     b   boolean
     *     s   string
     *     e   enum instance
     *     E   enum declaration
     *     C   class declaration
     *     m_  member of a class
     *     o   class instance (object)
     *     a_  array of
     *     al_ arraylist of
     * 
     * https://en.wikipedia.org/wiki/Hungarian_notation
     */
    enum m_ESmokingStatus { SMOKER, NON_SMOKER }
    
    int m_iPolicyNumber;
    String m_sProviderName;
    String m_sPolicyHolderFirstName;
    String m_sPolicyHolderLastName;
    int m_iPolicyHolderAge;
    m_ESmokingStatus m_ePolicyHolderSmokingStatus;
    double m_dPolicyHolderHeightInches;
    double m_dPolicyHolderWeightPounds;

    CPolicy()
    {
        m_iPolicyNumber = 0;
        m_sProviderName = "Example Provider";
        m_sPolicyHolderFirstName = "Example First Name";
        m_sPolicyHolderLastName = "Example Last Name";
        m_iPolicyHolderAge = 0;
        m_ePolicyHolderSmokingStatus = m_ESmokingStatus.
    }
}