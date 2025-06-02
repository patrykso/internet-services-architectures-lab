import { Component } from '@angular/core';
import {RouterLink, RouterLinkActive, RouterOutlet} from '@angular/router';
import {FooterComponent} from './component/footer/footer.component';
import {HeaderComponent} from './component/header/header.component';
import {MainComponent} from './component/main/main.component';
import {NavComponent} from './component/nav/nav.component';

@Component({
  selector: 'app-root',
  imports: [FooterComponent, HeaderComponent, MainComponent, NavComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'movies-frontend';
}
