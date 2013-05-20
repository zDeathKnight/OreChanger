package com.Knights.OreChanger;
/*made by zDeathKnightz (minecraft.net) 
AKA EmoKnight (minecraftforum.net)  
AKA Mark Ian Cooper
Copyright by zDeathKnightz AKA Mark Cooper*/
import java.util.*;

@SuppressWarnings("serial")
public class PropertieReader extends Properties
{

    public PropertieReader()
    {
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public synchronized Enumeration keys()
    {
		Enumeration enumeration = super.keys();
        Vector vector = new Vector();
        for(; enumeration.hasMoreElements(); vector.add(enumeration.nextElement())) { }
        Collections.sort(vector);
        return vector.elements();
    }
    
    

	
}