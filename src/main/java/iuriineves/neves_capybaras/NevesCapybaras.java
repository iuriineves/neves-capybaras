package iuriineves.neves_capybaras;

import iuriineves.neves_capybaras.init.ModBlocks;
import iuriineves.neves_capybaras.init.ModEntities;
import iuriineves.neves_capybaras.init.ModItems;
import iuriineves.neves_capybaras.init.ModSoundEvents;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NevesCapybaras implements ModInitializer {
    public static final String MOD_ID = "neves_capybaras";
    public static final Logger LOGGER = LoggerFactory.getLogger("neves_capybaras");



	@Override
	public void onInitialize() {

		ModEntities.initialize();
		ModItems.initialize();
		ModSoundEvents.initialize();
		ModBlocks.initialize();

	}
}