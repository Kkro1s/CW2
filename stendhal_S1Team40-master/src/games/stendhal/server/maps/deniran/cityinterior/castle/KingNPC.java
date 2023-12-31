/***************************************************************************
 *                   (C) Copyright 2019-2023 - Stendhal                    *
 ***************************************************************************
 ***************************************************************************
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 ***************************************************************************/
package games.stendhal.server.maps.deniran.cityinterior.castle;

import java.util.Map;

import games.stendhal.common.Direction;
import games.stendhal.server.core.config.ZoneConfigurator;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.entity.RPEntity;
import games.stendhal.server.entity.npc.SpeakerNPC;


public class KingNPC implements ZoneConfigurator {

	@Override
	public void configureZone(StendhalRPZone zone, Map<String, String> attributes) {
		buildNPC(zone);
	}

	private void buildNPC(final StendhalRPZone zone) {
		final SpeakerNPC npc = new SpeakerNPC("King Edward of Deniran") {
			@Override
			public void createDialog() {
				addGreeting("Hello, and welcome to Deniran castle.");
				addJob("We are the king!");
				addQuest("I don't have anything for you at the moment. But... There have been rumors of blordroughs digging caves under the city. I will probobly need your help in the future.");
				addGoodbye("Fare thee well, stranger!");
			}

			@Override
			protected void onGoodbye(RPEntity player) {
				setDirection(Direction.DOWN);
			}
		};
		npc.setPosition(14,7);
		npc.setEntityClass("deniran_king");
		npc.setDescription("You see the King of Deniran.");
		npc.setDirection(Direction.DOWN);
		zone.add(npc);
	}
}
