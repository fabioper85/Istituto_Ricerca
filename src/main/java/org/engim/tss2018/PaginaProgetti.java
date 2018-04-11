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
package org.engim.tss2018;

import java.util.LinkedList;
import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.engim.tss2018.db.ChiavePrimaria;
import org.engim.tss2018.db.Progetti;

/**
 *
 * @author svilupposw
 */
public class PaginaProgetti extends PaginaConMenu
{

  public PaginaProgetti()
  {
     List<IColumn<Progetti, String>> colonne =
      new LinkedList<>();
    
           
    PropertyColumn<Progetti, String> codice =
      new PropertyColumn<>(Model.of("codice"), 
                            "codice");
    colonne.add(codice);
    
    PropertyColumn<Progetti, String> data_inizio =
      new PropertyColumn<>(Model.of("Data inizio"), 
                            "data_inizio");
    colonne.add(data_inizio);

    PropertyColumn<Progetti, String> data_fine =
            
      new PropertyColumn<>(Model.of("Data fine"), 
                            "data_fine");
    colonne.add(data_fine);
    
     PropertyColumn<Progetti, String> budget =
            
      new PropertyColumn<>(Model.of("Budegt"), 
                            "budegt");
    colonne.add(budget);
    
     PropertyColumn<Progetti, String> id_team =
            
      new PropertyColumn<>(Model.of("Id Team"), 
                            "id_team");
    colonne.add(id_team);
    
   
    // INSERISCO IL PULSANTE ELIMINA
   AbstractColumn<Progetti, String> azioni = 
      new AbstractColumn<Progetti, String> (Model.of("Azioni"))
      {
        @Override
          public void populateItem(Item<ICellPopulator<Progetti>> item, 
                  String wicketid, final IModel<Progetti> imodel)
          {             
             //item.add(new AzioniPanel(wicketid, imodel.getObject()));
          }
      };
    
    colonne.add(azioni);
    
    
     SPDataProvider<Progetti> dp = 
            new SPDataProvider<>(Progetti.class);
    
    DefaultDataTable tab =
      new DefaultDataTable("elencoprogetti",
                           colonne,
                           dp,
                           5);
    add(tab);
  }
  
}
