#osgi env
#nohup java -Xms512m -Xmx1024m -jar org.eclipse.osgi_3.11.3.v20170209-1843.jar &

SERVICE_NAME=osgi
SERVICE_DIR=/usr/workspace/Chapter1
JAR_CONSOLE_NAME=org.eclipse.osgi_3.11.3.v20170209-1843
JAR_NAME=${SERVICE_DIR}/${JAR_CONSOLE_NAME}.jar
PID=${SERVICE_DIR}/${JAR_CONSOLE_NAME}.pid

cd ${SERVICE_DIR}

case "${1}" in
	start )
		nohup java -Xms512m -Xmx1024m -jar ${JAR_NAME} &
		echo $! > ${PID}
		echo "${SERVICE_NAME} started"
		;;

	stop)
		if [[ -f "${PID}" ]]; then
			#statements
			kill `cat ${PID}`
			rm -rf ${PID}
			echo "${SERVICE_NAME} stoped"
		elif [[ ! -f "PID" ]]; then
			#statements
			echo "${SERVICE_NAME} is not start"
		fi
		;;

	restart)
		$0 stop
		sleep 2
		$0 start
		echo "${SERVICE_NAME} restarted"
		;;

	status)
		ps -aux|grep ${SERVICE_NAME}
		echo $!
		;;

	*)
		echo "请输入正确参数"
		;;
esac
exit 0
