package Knights.OreChanger.Items;


import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemGoldOre  extends Item {

	public ItemGoldOre(int par1) {
		super(par1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon("OreChanger:GoldOre");
    }
}
