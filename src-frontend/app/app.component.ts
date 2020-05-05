import { Component } from '@angular/core';
import * as firebase from 'firebase';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'pfa';
  constructor() {
    const firebaseConfig = {
      apiKey: 'AIzaSyBmvDaE4mPt8ZHPTqO-1eo481FfKV2tmAw',
      authDomain: 'pfa-v01.firebaseapp.com',
      databaseURL: 'https://pfa-v01.firebaseio.com',
      projectId: 'pfa-v01',
      storageBucket: 'pfa-v01.appspot.com',
      messagingSenderId: '85235220871',
      appId: '1:85235220871:web:e7b6ed2425415cf21b5322',
      measurementId: 'G-83056N3HNF'
    };
    firebase.initializeApp(firebaseConfig);

  }
}
