# envoy-mesh
Simple envoy microservice mesh for OCP.

oc new-project envoy-mesh

oc new-build fabric8/s2i-java~https://github.com/elos-tech/envoy-mesh.git --context-dir=masterservice --name=masterservice

oc new-build fabric8/s2i-java~https://github.com/elos-tech/envoy-mesh.git --context-dir=demo-service --name=demoservice
