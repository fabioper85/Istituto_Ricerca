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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author svilupposw
 */
@Entity
@Table(name = "team")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t")
  , @NamedQuery(name = "Team.findById", query = "SELECT t FROM Team t WHERE t.id = :id")
})
public class Team implements Serializable, ChiavePrimaria
{

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTeam")
  private Collection<Progetti> progettiCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTeam")
  private Collection<Ricercatori> ricercatoriCollection;
  @JoinColumn(name = "id_teamleader", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Ricercatori idTeamleader;
  @JoinColumn(name = "id_area", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Aree idArea;

  public Team()
  {
  }

  public Team(Integer id)
  {
    this.id = id;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  @XmlTransient
  public Collection<Progetti> getProgettiCollection()
  {
    return progettiCollection;
  }

  public void setProgettiCollection(Collection<Progetti> progettiCollection)
  {
    this.progettiCollection = progettiCollection;
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

  public Ricercatori getIdTeamleader()
  {
    return idTeamleader;
  }

  public void setIdTeamleader(Ricercatori idTeamleader)
  {
    this.idTeamleader = idTeamleader;
  }

  public Aree getIdArea()
  {
    return idArea;
  }

  public void setIdArea(Aree idArea)
  {
    this.idArea = idArea;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Team))
    {
      return false;
    }
    Team other = (Team) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
      return false;
    return true;
  }

  @Override
  public String toString()
  {
    return "org.engim.tss2018.db.Team[ id=" + id + " ]";
  }
  
}
