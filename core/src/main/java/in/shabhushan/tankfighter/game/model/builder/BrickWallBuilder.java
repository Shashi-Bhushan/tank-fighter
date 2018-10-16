/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Shashi Bhushan
 */
package in.shabhushan.tankfighter.game.model.builder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import in.shabhushan.tankfighter.game.core.TankFighterGame;
import in.shabhushan.tankfighter.game.model.impl.BrickWall;

@JsonPOJOBuilder(withPrefix = "set", buildMethodName = "build")
public class BrickWallBuilder extends GenericGameObjectBuilder<BrickWallBuilder> {

    @JsonCreator
    public BrickWallBuilder(@JsonProperty("horizontalPosition") int horizontalPosition, @JsonProperty("verticalPosition") int verticalPosition, TankFighterGame game) {
        this.horizontalPosition = horizontalPosition;
        this.verticalPosition = verticalPosition;
        this.game = game;
        this.objectSize = 30;
    }

    @Override
    public BrickWall build() {
        return new BrickWall(this);
    }
}
