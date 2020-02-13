import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './core/guards/auth.guard';
import { LayoutComponent } from './shared/components/layout/layout.component';


const routes: Routes = [
  { path: '', redirectTo: 'asaltos', pathMatch: 'full' },
  {
    path: 'login', loadChildren: () => import('./modules/login/login.module').then(m => m.LoginModule),
  },
  {
    path: 'bancos', loadChildren: () => import('./modules/entidades-bancarias/entidades-bancarias.module').then(m => m.BancosModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'bandas', loadChildren: () => import('./modules/bandas/bandas.module').then(m => m.BandasModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'jueces', loadChildren: () => import('./modules/jueces/jueces.module').then(m => m.JuecesModule),
    canActivate: [AuthGuard],
  },
  {
<<<<<<< HEAD
    path: 'vigilantes', loadChildren: () => import('./modules/Vigilantes/Vigilantes.module').then(m => m.VigilantesModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'usuarios', loadChildren: () => import('./modules/Usuarios/Usuarios.module').then(m => m.UsuariosModule),
    canActivate: [AuthGuard],
  },
=======
    path: 'delincuentes', loadChildren: () => import('./modules/delincuentes/delincuentes.module').then(m => m.DelincuentesModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'asaltos', loadChildren: () => import('./modules/asaltos/asaltos.module').then(m => m.AsaltosModule),
    // canActivate: [AuthGuard]
  }
>>>>>>> eb72542e843b9900b8ed04988f0cc0e37c1a53ec
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
