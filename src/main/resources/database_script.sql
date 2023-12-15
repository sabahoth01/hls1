
-- Create the "user" table
CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       username VARCHAR(100) UNIQUE not null,
                       password VARCHAR(100) not null
);

-- Create the "player" table
CREATE TABLE player (
                        player_id SERIAL PRIMARY KEY,
                        user_id INTEGER REFERENCES users(user_id) ON DELETE CASCADE,
                        first_name VARCHAR(100) not null ,
                        last_name VARCHAR(100) not null,
                        age INTEGER,
                        height_cm FLOAT,
                        weight_kg FLOAT,
                        gender VARCHAR(10)
);
-- Create playground table
CREATE TABLE playground (
                            playground_id SERIAL PRIMARY KEY,
                            playground_name varchar(100) not null,
                            sport_id integer references sport(sport_id),
                            location varchar(100) not null
);

-- Create the "sportType" table

CREATE TYPE sport_type AS ENUM ('Football', 'Basketball', 'Tennis', 'Baseball', 'Soccer');

CREATE TABLE sport (
                       sport_id SERIAL PRIMARY KEY,
                       sport_name sport_type
);



-- Create the "team" table
CREATE TABLE team (
                      team_id SERIAL PRIMARY KEY,
                      size integer ,
                      free_to_join boolean ,
                      team_name VARCHAR(50),
                      player_id INTEGER REFERENCES player(player_id) ON DELETE SET NULL
);

-- Create the "teamManager" table
CREATE TABLE teamManager (
                             teamManager_id SERIAL PRIMARY KEY,
                             player_id INTEGER REFERENCES users(user_id),
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
                                        availability BOOLEAN,
                                        available_from TIMESTAMP,
                                        available_to TIMESTAMP
);

-- Create the "booking" table
CREATE TYPE booking_type AS ENUM ('Team', 'Players');
CREATE TABLE booking (
                         booking_id SERIAL PRIMARY KEY,
                         playground_id INTEGER REFERENCES playground(playground_id) ON DELETE CASCADE,
                         player_id INTEGER REFERENCES player(player_id) ON DELETE SET NULL,
                         booking_date date,
                         booking_start_time TIME,
                         booking_end_time TIME,
                         booking_type booking_type,
                         team_id integer references team(team_id)

);

-- Create the many-to-many relationship table between "player" and "team"
CREATE TABLE player_team (
                             player_id INTEGER REFERENCES player(player_id) ON DELETE CASCADE,
                             team_id INTEGER REFERENCES team(team_id) ON DELETE CASCADE,
                             PRIMARY KEY (player_id, team_id)
);

-- Create the many-to-many relationship table between "player" and "role"
CREATE TABLE user_role (
                           user_id INTEGER REFERENCES users(user_id) ON DELETE CASCADE,
                           role_id INTEGER REFERENCES role(role_id) ON DELETE CASCADE,
                           PRIMARY KEY (user_id, role_id)
);

-- POPULATE

-- Insert statements for the "users" table
INSERT INTO users (
                   username,
                   password) VALUES
                                 ('user1', 'password1'),
                                 ('user2', 'password2'),
                                 ('user3', 'password3'),
                                 ('user4', 'password4'),
                                 ('user5', 'password5'),
                                 ('user6', 'password6'),
                                 ('user7', 'password7'),
                                 ('user8', 'password8'),
                                 ('user9', 'password9'),
                                 ('user10', 'password10');

-- Insert statements for the "player" table
INSERT INTO player (user_id,
                    first_name,
                    last_name,
                    age,
                    height_cm,
                    weight_kg,
                    gender) VALUES
                                (1, 'John', 'Doe', 25, 180, 75, 'Male'),
                                (2, 'Jane', 'Smith', 28, 165, 60, 'Female'),
                                (3, 'Michael', 'Johnson', 30, 175, 70, 'Male'),
                                (4, 'Emily', 'Davis', 23, 160, 55, 'Female'),
                                (5, 'Robert', 'Wilson', 27, 190, 85, 'Male'),
                                (6, 'Jessica', 'Brown', 26, 170, 65, 'Female'),
                                (7, 'David', 'Miller', 29, 185, 80, 'Male'),
                                (8, 'Sophia', 'Anderson', 24, 155, 50, 'Female'),
                                (9, 'Daniel', 'Taylor', 31, 180, 75, 'Male'),
                                (10, 'Olivia', 'Lee', 22, 165, 60, 'Female');

-- Insert statements for the "sport" table
INSERT INTO sport (sport_name) VALUES
                                   ('Football'),
                                   ('Basketball'),
                                   ('Tennis'),
                                   ('Baseball'),
                                   ('Soccer');

-- Insert statements for the "playground" table
INSERT INTO playground (playground_name,
                        sport_id,
                        location) VALUES
                                      ('Playground 1', 1, 'Location 1'),
                                      ('Playground 2', 2, 'Location 2'),
                                      ('Playground 3', 3, 'Location 3'),
                                      ('Playground 4', 4, 'Location 4'),
                                      ('Playground 5', 5, 'Location 5'),
                                      ('Playground 6', 1, 'Location 6'),
                                      ('Playground 7', 2, 'Location 7'),
                                      ('Playground 8', 3, 'Location 8'),
                                      ('Playground 9', 4, 'Location 9'),
                                      ('Playground 10', 5, 'Location 10');

-- Insert statements for the "team" table
INSERT INTO team (size,
                  free_to_join,
                  team_name,
                  player_id) VALUES
                                 (5, true, 'Team 1', 1),
                                 (7, true, 'Team 2', 2),
                                 (6, false, 'Team 3', 3),
                                 (4, true, 'Team 4', 4),
                                 (8, true, 'Team 5', 5),
                                 (5, false, 'Team 6', 6),
                                 (6, true, 'Team 7', 7),
                                 (7, true, 'Team 8', 8),
                                 (4, true, 'Team 9', 9),
                                 (5, false, 'Team 10', 10);

-- Insert statements for the "teamManager" table
INSERT INTO teamManager (player_id, team_id) VALUES
                                                 (1, 1),
                                                 (2, 2),
                                                 (3, 3),
                                                 (4, 4),
                                                 (5, 5),
                                                 (6, 6),
                                                 (7, 7),
                                                 (8, 8),
                                                 (9, 9),
                                                 (10, 10);

-- Insert statements for the "role" table
INSERT INTO role (role_name) VALUES
                                 ('Role 1'),
                                 ('Role 2'),
                                 ('Role 3'),
                                 ('Role 4'),
                                 ('Role 5'),
                                 ('Role 6'),
                                 ('Role 7'),
                                 ('Role 8'),
                                 ('Role 9'),
                                 ('Role 10');

-- Insert statements for the "playgroundAvailability" table
INSERT INTO playgroundAvailability (playground_id,
                                    availability,
                                    available_from,
                                    available_to) VALUES
                                                      (1, true, NOW(), NOW() + INTERVAL '1 hour'),
                                                      (2, true, NOW(), NOW() + INTERVAL '2 hours'),
                                                      (3, false, NOW(), NOW() + INTERVAL '3 hours'),
                                                      (4, true, NOW(), NOW() + INTERVAL '4 hours'),
                                                      (5, true, NOW(), NOW() + INTERVAL '5 hours'),
                                                      (6, false, NOW(), NOW() + INTERVAL '6 hours'),
                                                      (7, true, NOW(), NOW() + INTERVAL '7 hours'),
                                                      (8, true, NOW(), NOW() + INTERVAL '8 hours'),
                                                      (9, true, NOW(), NOW() + INTERVAL '9 hours'),
                                                      (10, false, NOW(), NOW() + INTERVAL '10 hours');

-- Insert statements for the "booking" table
INSERT INTO booking (playground_id,
                     player_id,
                     booking_date,
                     booking_start_time,
                     booking_end_time,
                     booking_type,
                     team_id) VALUES
                                  (1, 1, CURRENT_DATE, '10:00:00', '12:00:00', 'Team', 1),
                                  (2, 2, CURRENT_DATE, '14:00:00', '16:00:00', 'Players', 2),
                                  (3, 3, CURRENT_DATE, '12:00:00', '14:00:00', 'Team', 3),
                                  (4, 4, CURRENT_DATE, '16:00:00', '18:00:00', 'Players', 4),
                                  (5, 5, CURRENT_DATE, '18:00:00', '20:00:00', 'Team', 5),
                                  (6, 6, CURRENT_DATE, '20:00:00', '22:00:00', 'Players', 6),
                                  (7, 7, CURRENT_DATE, '10:00:00', '12:00:00', 'Team', 7),
                                  (8, 8, CURRENT_DATE, '12:00:00', '14:00:00', 'Players', 8),
                                  (9, 9, CURRENT_DATE, '14:00:00', '16:00:00', 'Team', 9),
                                  (10, 10, CURRENT_DATE, '16:00:00', '18:00:00', 'Players', 10);

-- Insert statements for the "player_team" table
INSERT INTO player_team (player_id, team_id) VALUES
                                                 (1, 1),
                                                 (2, 2),
                                                 (3, 3),
                                                 (4, 4),
                                                 (5, 5),
                                                 (6, 6),
                                                 (7, 7),
                                                 (8, 8),
                                                 (9, 9),
                                                 (10, 10);
