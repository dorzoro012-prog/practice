SE LAB2 — 12 UNIQUE ANNOTATED QUESTION SETS
Original ZIP: 17 DOCX files. Duplicate detection uses extracted paragraph+table content (exact text), not filenames.

Files: each unique set has an annotated DOCX with original questions followed by solutions for each main question, plus a _support folder of copyable reference code.
IMPORTANT: Companion reference files containing multiple file fragments (commented with # File:) are NOTES/TEMPLATES, not ready-to-run config without splitting into named files. Prefer DOCX instructions to assemble files.

BEFORE YOU RUN (read once): Commands below are examples for PowerShell on Windows unless marked Ubuntu/EC2, Jenkinsfile (Groovy), Dockerfile, YAML, or browser. Replace YOUR_DOCKERHUB_USER, YOUR_IMAGE, YOUR_PUBLIC_IP, KEY.pem, passwords, email, AWS region, and repository-specific paths. Do not type angle-bracket placeholders literally. Check pom.xml (packaging, Java version, artifact name), README, database configuration and existing Dockerfiles before choosing a build method. The supplied question paper does not guarantee that every referenced repository is executable as-is. Never publish credentials or expose MySQL to the public Internet. Docker and Minikube may use ports already occupied on your computer; choose unused host ports. A successful container start is not proof the app or database works: verify logs, HTTP response, and application behavior.

UNIQUE FILE MAP:
dated_SET-1.docx <= SE lab2/17-11-26/SET-1.docx | sections: docker, jenkins, k8s, nagios, aws | https://github.com/kvrajanirajesh/mid2-ecommercemaven
dated_SET-2.docx <= SE lab2/17-11-26/SET-2.docx | sections: docker, jenkins, k8s, nagios, aws | https://github.com/kvrajanirajesh/mid2-hospitalmaven
dated_SET-3.docx <= SE lab2/17-11-26/SET-3.docx | sections: docker, jenkins, k8s, nagios, aws | https://github.com/kvrajanirajesh/mid1-e-learningmaven
dated_SET-4.docx <= SE lab2/17-11-26/SET-4.docx | sections: compose, jenkins, k8s, aws | https://github.com/archanareddyse/OLTRS.git
dated_SET-5.docx <= SE lab2/17-11-26/SET-5.docx | sections: compose, jenkins, k8s, aws | https://github.com/archanareddyse/OLTRS.git
dated_SET-6.docx <= SE lab2/17-11-26/SET-6.docx | sections: compose_nagios, jenkins, k8s, aws | https://github.com/archanareddyse/OLTRS.git
dated_SET-7.docx <= SE lab2/17-11-26/SET-7.docx | sections: docker, jenkins, nagios, k8s, aws | https://github.com/deepthisagar7/metro-reservation.git
dated_SET-8.docx <= SE lab2/17-11-26/SET-8.docx | sections: flask, jenkins, k8s, aws | https://github.com/Kumbhambhargavi75/FoodSystem
main_SET-1.docx <= SE lab2/SET-1.docx | sections: docker, jenkins, k8s, nagios, aws | https://github.com/deepthisagar7/library-management.git
main_SET-3.docx <= SE lab2/SET-3.docx | sections: docker, jenkins, nagios, k8s, aws | https://github.com/deepthisagar7/AI-OLMS.git
main_SET-4.docx <= SE lab2/SET-4.docx | sections: jenkins, email, k8s, aws | https://github.com/Kumbhambhargavi75/HospitalManagementSystem
main_SET-6.docx <= SE lab2/SET-6.docx | sections: compose, jenkins, k8s, k8s, aws | https://github.com/Kumbhambhargavi75/CEMS

EXCLUDED DUPLICATE COPIES:
SE lab2/SET-2.docx duplicates SE lab2/17-11-26/SET-7.docx
SE lab2/SET-5.docx duplicates SE lab2/17-11-26/SET-8.docx
SE lab2/SET-7.docx duplicates SE lab2/17-11-26/SET-5.docx
SE lab2/SET-8.docx duplicates SE lab2/17-11-26/SET-6.docx
SE lab2/SET-9.docx duplicates SE lab2/17-11-26/SET-4.docx

VALIDATION LIMITS: No Docker, Jenkins, Kubernetes or AWS actions were executed. External repos may have dependencies, packaging requirements, Java versions or application-specific DB settings not defined by the question papers. Repo structure must be checked before running any artifact-dependent command.

Useful references: https://docs.docker.com/compose/ ; https://www.jenkins.io/doc/book/pipeline/ ; https://kubernetes.io/docs/ ; https://docs.aws.amazon.com/ec2/ ; https://www.nagios.org/documentation/