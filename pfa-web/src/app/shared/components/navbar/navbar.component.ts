import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/core/services/api/auth.service';
import { RoleLabel } from 'src/app/core/models/role';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  roleLabel = RoleLabel;

  constructor(public authService: AuthService) { }

  ngOnInit() {
  }

}
