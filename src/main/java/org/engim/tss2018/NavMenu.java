
package org.engim.tss2018;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

public class NavMenu extends Panel
{

  public NavMenu(String id)
  {
    super(id);
    
    BookmarkablePageLink home = new BookmarkablePageLink("home", HomePage.class);
    add(home);

    home.add(new AttributeModifier("class", "nav-link"));
  } 
}
