# studentmanagement

first create jar file by running this 
-mvn clean package
above command give error then use this
-mvn clean package -DskipTests    

create image by using this
-docker build -t projectfoldername .

first we create mysql that purpose run this
-docker compose up --build


#using K8s we use this commands
cd student-management
cd k8s

kubectl apply -f secret.yaml
kubectl apply -f mysql-pvc.yaml
kubectl apply -f mysql-deployment.yaml
kubectl apply -f mysql-service.yaml
kubectl apply -f springboot-deployment.yaml
kubectl apply -f springboot-service.yaml


or  

kubectl apply -f .


kubectl get pods
kubectl get svc
http://localhost:30080


you want to stop run this command

kubectl delete -f .

or

kubectl scale deployment student-app --replicas=0
kubectl scale deployment mysql --replicas=0 
kubectl get pods

you want start again run this

kubectl scale deployment student-app --replicas=1
kubectl scale deployment mysql --replicas=1


