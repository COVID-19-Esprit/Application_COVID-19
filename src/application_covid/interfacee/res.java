/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_covid.interfacee;

/**
 *
 * @author A
 */
public class res {

    private String recovered;

    private String lastUpdate;

    private String totalCases;

    private String deaths;

    private String activeCases;

    private String closedCases;

    public String getRecovered ()
    {
        return recovered;
    }

    public void setRecovered (String recovered)
    {
        this.recovered = recovered;
    }

    public String getLastUpdate ()
    {
        return lastUpdate;
    }

    public void setLastUpdate (String lastUpdate)
    {
        this.lastUpdate = lastUpdate;
    }

    public String getTotalCases ()
    {
        return totalCases;
    }

    public void setTotalCases (String totalCases)
    {
        this.totalCases = totalCases;
    }

    public String getDeaths ()
    {
        return deaths;
    }

    public void setDeaths (String deaths)
    {
        this.deaths = deaths;
    }

    public String getActiveCases ()
    {
        return activeCases;
    }

    public void setActiveCases (String activeCases)
    {
        this.activeCases = activeCases;
    }

    public String getClosedCases ()
    {
        return closedCases;
    }

    public void setClosedCases (String closedCases)
    {
        this.closedCases = closedCases;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [recovered = "+recovered+", lastUpdate = "+lastUpdate+", totalCases = "+totalCases+", deaths = "+deaths+", activeCases = "+activeCases+", closedCases = "+closedCases+"]";
    }
}
    

