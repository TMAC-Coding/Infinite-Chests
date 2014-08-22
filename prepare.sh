sudo start xvfb
print "Receiving all Files..."
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/craftbukkit.jar --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/bukkit.yml --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/banned-ips.json --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/banned-players.json --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/ops.json --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/whitelist.json --quiet
mkdir dir="world"
cd world
mkdir dir="region"
cd region
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world/region/r.0.0.mca --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world/region/r.-1.0.mca --quiet
cd ..
cd ..
mkdir dir="world_nether"
cd world_nether
mkdir dir="DIM-1"
cd DIM-1
mkdir dir="region"
cd region
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_nether/DIM-1/region/r.0.0.mca --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_nether/DIM-1/region/r.0.-1.mca --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_nether/DIM-1/region/r.-1.0.mca --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_nether/DIM-1/region/r.-1.-1.mca --quiet
cd ..
cd ..
cd ..
mkdir dir="world_the_end"
cd world_the_end
mkdir dir="DIM-1"
cd DIM-1
mkdir dir="region"
cd region
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_the_end/DIM1/region/r.0.0.mca --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_the_end/DIM1/region/r.0.-1.mca --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_the_end/DIM1/region/r.-1.0.mca --quiet
wget https://dl.dropboxusercontent.com/u/54314339/bukkit/world_the_end/DIM1/region/r.-1.-1.mca --quiet
cd ..
cd ..
cd ..
print "Finished Receiving."