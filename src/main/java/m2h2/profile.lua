-- my_profile.lua
-- Define the profile for car routing

-- Define the vehicle profile
-- This determines the maximum speed and other characteristics of the vehicle
-- See the OSRM documentation for more options and details
profiles = {
  car = {
    -- Define the maximum speed of the car in meters per second
    speed_profile = {
      ["motorway"] = 25,
      ["trunk"] = 20,
      ["primary"] = 18,
      ["secondary"] = 15,
      ["tertiary"] = 12,
      ["residential"] = 10,
      ["unclassified"] = 10,
      ["service"] = 10,
      ["track"] = 10
    },
    -- Define the turn costs for the car
    -- These values affect routing decisions at intersections
    turn_costs = {
      -- Define the turn costs in seconds for each turn type
      -- Adjust these values based on your preferences and local traffic conditions
      u_turn_penalty = 20,
      turn_penalty = 7,
      -- Add more turn costs as needed
    }
  }
}

-- Return the profiles table
-- This makes the profile settings available to the OSRM routing engine
return profiles
