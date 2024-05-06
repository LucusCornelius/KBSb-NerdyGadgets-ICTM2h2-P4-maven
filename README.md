### Project clonen: https://blog.jetbrains.com/idea/2020/10/clone-a-project-from-github/
### I.P.V. een url kun je beter via github clonen. Dit staat onder 'repository url'. Dan kun je hem hier selecteren nadat je de uitnodiging in de mail hebt geaccepteerd.

### 2. Dataset download links.
* Item 1
   * link1
   * link2 


### 3. Open Source Routing System

1. wget http://download.geofabrik.de/europe/netherlands-latest.osm.pbf
2. docker run -t -v "${PWD}:/data" ghcr.io/project-osrm/osrm-backend osrm-extract -p /opt/car.lua /data/netherlands-latest.osm.pbf || echo "osrm-extract failed"


3. docker run -t -v "${PWD}:/data" ghcr.io/project-osrm/osrm-backend osrm-partition /data/netherlands-latest.osrm || echo "osrm-partition failed"
4. docker run -t -v "${PWD}:/data" ghcr.io/project-osrm/osrm-backend osrm-customize /data/netherlands-latest.osrm || echo "osrm-customize failed"


5. docker run -t -i -p 5000:5000 -v "${PWD}:/data" ghcr.io/project-osrm/osrm-backend osrm-routed --algorithm mld /data/netherlands-latest.osrm

6. docker run -p 9966:9966 osrm/osrm-frontend 
7. xdg-open 'http://127.0.0.1:9966'