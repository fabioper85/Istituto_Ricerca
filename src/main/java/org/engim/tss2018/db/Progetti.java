/*
 * Copyright 2018 svilupposw.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.engim.tss2018.db;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author svilupposw
 */
@Entity
@Table(name = "progetti")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Progetti.findAll", query = "SELECT p FROM Progetti p")
  , @NamedQuery(name = "Progetti.findByCodice", query = "SELECT p FROM Progetti p WHERE p.codice = :codice")
  , @NamedQuery(name = "Progetti.findByDataInizio", query = "SELECT p FROM Progetti p WHERE p.dataInizio = :dataInizio")
  , @NamedQuery(name = "Progetti.findByDataFine", query = "SELECT p FROM Progetti p WHERE p.dataFine = :dataFine")
  , @NamedQuery(name = "Progetti.findByBudget", query = "SELECT p FROM Progetti p WHERE p.budget = :budget")
})
public class Progetti implements Serializable
{

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "codice")
  private Integer codice;
  @Basic(optional = false)
  @NotNull
  @Column(name = "data_inizio")
  @Temporal(TemporalType.DATE)
  private Date dataInizio;
  @Column(name = "data_fine")
  @Temporal(TemporalType.DATE)
  private Date dataFine;
  @Basic(optional = false)
  @NotNull
  @Column(name = "budget")
  private double budget;
  @JoinColumn(name = "id_team", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Team idTeam;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProgetto")
  private Collection<Ricercatori> ricercatoriCollection;

  public Progetti()
  {
  }

  public Progetti(Integer codice)
  {
    this.codice = codice;
  }

  public Progetti(Integer codice, Date dataInizio, double budget)
  {
    this.codice = codice;
    this.dataInizio = dataInizio;
    this.budget = budget;
  }

  public Integer getCodice()
  {
    return codice;
  }

  public void setCodice(Integer codice)
  {
    this.codice = codice;
  }

  public Date getDataInizio()
  {
    return dataInizio;
  }

  public void setDataInizio(Date dataInizio)
  {
    this.dataInizio = dataInizio;
  }

  public Date getDataFine()
  {
    return dataFine;
  }

  public void setDataFine(Date dataFine)
  {
    this.dataFine = dataFine;
  }

  public double getBudget()
  {
    return budget;
  }

  public void setBudget(double budget)
  {
    this.budget = budget;
  }

  public Team getIdTeam()
  {
    return idTeam;
  }

  public void setIdTeam(Team idTeam)
  {
    this.idTeam = idTeam;
  }

  @XmlTransient
  public Collection<Ricercatori> getRicercatoriCollection()
  {
    return ricercatoriCollection;
  }

  public void setRicercatoriCollection(Collection<Ricercatori> ricercatoriCollection)
  {
    this.ricercatoriCollection = ricercatoriCollection;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (codice != null ? codice.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Progetti))
    {
      return false;
    }
    Progetti other = (Progetti) object;
    if ((this.codice == null && other.codice != null) || (this.codice != null && !this.codice.equals(other.codice)))
      return false;
    return true;
  }

  @Override
  public String toString()
  {
    return "org.engim.tss2018.db.Progetti[ codice=" + codice + " ]";
  }
  
}
