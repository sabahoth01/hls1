
-- Create the "player" table
CREATE TABLE player (
                        player_id SERIAL PRIMARY KEY,
                        user_id INTEGER REFERENCES users(user_id) ON DELETE CASCADE,
                        -- player_name VARCHAR(100),
                        -- player_surname VARCHAR(100),
                        -- age INTEGER,
                        height_cm FLOAT,
                        weight_kg FLOAT
                        -- gender VARCHAR(10)

);

-- Create the "playground" table
CREATE TYPE playgroundName AS ENUM ('F', 'H', 'T', 'B', 'М');
CREATE TYPE locationName AS ENUM ('F', 'J', 'T', 'B', 'L');

CREATE TABLE playground (
                            playground_id SERIAL PRIMARY KEY,
                            playground_name playgroundName,
                            location locationName
);

-- Create the "sportType" table

CREATE TYPE sport_type AS ENUM ('Football', 'Basketball', 'Tennis', 'Baseball', 'Soccer');

CREATE TABLE sport (
                           sport_id SERIAL PRIMARY KEY,
                           sport_name sport_type,
                           playground_id INTEGER REFERENCES playground(playground_id)
);

-- Create the "user" table
CREATE TABLE users (
                      user_id SERIAL PRIMARY KEY,
                      first_name VARCHAR(100) not null ,
                      last_name VARCHAR(100) not null,
                      username VARCHAR(100) not null,
                      email VARCHAR(50) not null,
                      age INTEGER,
                      password VARCHAR(100) not null,
                      phone VARCHAR(15) not null,
                      gender VARCHAR(10)
);

-- Create the "team" table
CREATE TABLE team (
                      team_id SERIAL PRIMARY KEY,
                      team_name VARCHAR(50),
                      captain_id INTEGER REFERENCES player(player_id) ON DELETE SET NULL
);

-- Create the "teamManager" table
CREATE TABLE teamManager (
                             teamManager_id SERIAL PRIMARY KEY,
                             -- manager_name VARCHAR(100),
                             -- manager_surname VARCHAR(100),
                             user_id INTEGER REFERENCES users(user_id),
                             team_id INTEGER REFERENCES team(team_id) ON DELETE SET NULL
);

-- Create the "role" table
CREATE TABLE role (
                      role_id SERIAL PRIMARY KEY,
                      role_name VARCHAR(50)
);

-- Create the "playgroundAvailability" table
CREATE TABLE playgroundAvailability (
                                        playgroundAvailability_id SERIAL PRIMARY KEY,
                                        playground_id INTEGER REFERENCES playground(playground_id) ON DELETE CASCADE,
                                        -- sportType_id INTEGER REFERENCES sport(sport_id) ON DELETE CASCADE,
                                        availability BOOLEAN,
                                        available_from TIMESTAMP,
                                        available_to TIMESTAMP
);

-- Create the "booking" table
CREATE TABLE booking (
                         booking_id SERIAL PRIMARY KEY,
                         playgroundAvailability_id INTEGER REFERENCES playgroundAvailability(playgroundAvailability_id) ON DELETE CASCADE,
                         -- player_id INTEGER REFERENCES player(player_id) ON DELETE SET NULL,
                         teamManager_id INTEGER REFERENCES teamManager(teamManager_id) ON DELETE SET NULL,
                         booking_start_time TIMESTAMP,
                         booking_end_time TIMESTAMP
);

-- -- Create the "admin" table
-- CREATE TABLE admin (
--                        admin_id SERIAL PRIMARY KEY,
--                        admin_name VARCHAR(50),
--                        user_id INTEGER REFERENCES users(user_id) ON DELETE SET NULL
-- );

-- Create the many-to-many relationship table between "player" and "team"
CREATE TABLE player_team (
                             player_id INTEGER REFERENCES player(player_id) ON DELETE CASCADE,
                             team_id INTEGER REFERENCES team(team_id) ON DELETE CASCADE,
                             PRIMARY KEY (player_id, team_id)
);

-- Create the many-to-many relationship table between "player" and "role"
CREATE TABLE user_role (
                             player_id INTEGER REFERENCES player(player_id) ON DELETE CASCADE,
                             role_id INTEGER REFERENCES role(role_id) ON DELETE CASCADE,
                             PRIMARY KEY (player_id, role_id)
);