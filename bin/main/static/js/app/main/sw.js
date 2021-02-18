
  const isSupported = 'serviceWorker' in navigator;

  if (!isSupported) {
    //return;
	  console.log('서비스 워커가 지원되는 브라우저 입니다.');
  }


  /*
  
  const runtime = require('serviceworker-webpack-plugin/lib/runtime');

  runtime.register().then(res => {
    console.log('서비스 워커 설치 성공 ->', res);
  }).catch(e => {
    console.log('서비스 워커 설치 실패 ㅜㅜ -> ', e);
  });
  
   */
  
/*
isSupportNotification () {
	  return process.browser && window && 'Notification' in window;
}
*/
  
/*
getNotificationPermission () {
	  if (!this.isSupportNotification()) {
	    this.isAllowNotification = false;
	    return Promise.reject(new Error('not_supported'));
	  }

	  if (Notification.permission === 'granted') {
	    this.isAllowNotification = true;
	    return Promise.resolve();
	  }
	  else if (Notification.permission !== 'denied' || Notification.permission === 'default') {
	    return Notification.requestPermission().then(result => {
	      if (result === 'granted') {
	        this.isAllowNotification = true;
	      }
	    });
	  }
	}


createForegroundNotification (title, { body, icon, link }) {
	  const notification = new Notification(title, {
	    body,
	    icon: icon
	  });

	  notification.onshow = () => {
	    setTimeout(() => notification.close(), 5000);
	  };
	  notification.onerror = e => {
	    console.error(e);
	  };
	  notification.onclick = event => {
	    event.preventDefault();
	    if (link) {
	        window.open(link, '_blank');
	    }
	  };
	}


async subscribeNotification () {
	  if (!this.isSupportNotification()) {
	    return;
	  }

	  await this.getNotificationPermission();
	  if (!this.isAllowNotification) {
	    return;
	  }

	  const channel = await this.getPrivateUserChannel();
	  channel.bind('message', response => {
	    if (response.sender.id === this.myUserId) {
	      return;
	    }

	    const targetChatRoute = !!response.sender.provider ? 'chats' : 'pro/chats';
	    this.createForegroundNotification(, {
	      body: response.message,
	      icon: response.sender.profile_image,
	      link: ,
	    });
	  });
	}
*/