import { Component } from '@angular/core';
import { trigger, transition, query, style, animate, group } from '@angular/animations';
import { LeftRightTransitionAnimation } from './shared/animations/left-right-transition.animation';

@Component({
  selector: 'app-root',
  template:
    `<app-navbar></app-navbar>
    <div [@myAnimation]="o.isActivated ? o.activatedRoute : ''">
        <router-outlet #o="outlet"></router-outlet>
    </div>`,
  animations: [
    LeftRightTransitionAnimation
  ]
})
export class AppComponent {
  title = 'pfa-web';
}
