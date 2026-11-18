# AWS Console: EC2 > Launch Instance > Ubuntu Server (confirm correct free-tier eligibility)
# Choose region, instance type, key pair, VPC/public subnet and Public IPv4 assignment.
# Security group inbound: SSH TCP 22 from YOUR_PUBLIC_IP/32, HTTP TCP 80 from 0.0.0.0/0;
# for direct Tomcat testing, TCP 8080 from your IP (or use a reverse proxy on 80).
# Outbound must allow needed downloads; instance subnet route table needs internet gateway.
# From LOCAL PowerShell (path/key and public IP are placeholders):
ssh -i .\KEY.pem ubuntu@YOUR_PUBLIC_IP
# On Ubuntu EC2 terminal (not PowerShell):
sudo apt-get update
sudo apt-get install -y git docker.io
sudo systemctl enable --now docker
sudo docker run -d --name se-site --restart unless-stopped -p 80:80 nginx:alpine
curl -I http://localhost
# Browser from your computer: http://YOUR_PUBLIC_IP
# To deploy your own static index.html: create index.html on EC2, then:
# sudo docker run -d --name se-home -p 80:80 -v "$PWD/index.html:/usr/share/nginx/html/index.html:ro" nginx:alpine
# Stop se-site first to free port 80: sudo docker rm -f se-site
# For Java WAR: clone GitHub repo, inspect pom.xml, build with JDK + Maven, make WAR Docker image;
# port example: sudo docker run -d -p 8080:8080 YOUR_DOCKERHUB_USER/se-lab-app:1
# then allow inbound 8080 ONLY if required, or configure Nginx reverse proxy.
# To monitor: AWS Console > EC2 > Monitoring > CloudWatch; basic EC2 metrics include CPU,
# network and status checks. Memory/disk utilization require CloudWatch Agent installation.
# Cleanup: sudo docker rm -f se-site ; AWS EC2 console > Instance state > Terminate.
# AWS resources can incur charges; removing Docker containers alone does not stop EC2 billing.
