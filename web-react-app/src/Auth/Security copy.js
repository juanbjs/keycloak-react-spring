import React from 'react';
import Keycloak from 'keycloak-js';

import { Store } from "../Provider/Store";

class Security extends React.Component {
  constructor() {
    super();
    this.state = {
      keycloak: null,
      authenticated: false,
    };

    this.onHandleLogOutClick = this.onHandleLogOutClick.bind(this);
    this.logout = this.logout.bind(this);
    //const [ state, dispatch ] = React.useContext(Store);
  }

  async verifyLogin() {
    const keycloak = Keycloak('/keycloak.json');

    console.log("keycloak", keycloak)

    await keycloak
      .init(
        { onLoad: 'login-required' }
      )
      .success((auth) => {

        if (!auth) {
          window.location.reload();
        } else {
          this.setState(
            {
              keycloak: keycloak,
              authenticated: auth
            }
          )
        }
      }).error((err) => {
        console.error("Authenticated Failed", err);
      });
  }

  accessDenied() {
    this.props.history.push('/accesoDenegado');
  }

  async componentDidMount() {
    await this.verifyLogin();
  }

  componentDidUpdate() {

  }

  logout() {
    this.props.history.push('/');
    this.state.keycloak.logout();
  }

  onHandleLogOutClick() {
    this.logout();
  }

  homeMenuClick() {
    this.props.history.push('/')
  }

  authorization() {

    try {
      if (!this.state.keycloak.resourceAccess) {
        return false;
      }

      if (!this.state.keycloak.resourceAccess.backoffice_micabal) {
        return false;
      }

      if (this.state.keycloak.resourceAccess.backoffice_micabal.roles === 0) {
        return false;
      }
    } catch (error) {
      console.log("error -> " + error);
      return false;
    }

    return true;
  }

  validateRoles(rol) {
    if (this.authorization()) {
      if (this.state.keycloak.resourceAccess.backoffice_micabal.roles.includes(rol)) {
        return true;
      }
    }
    return false;
  }

  render() {
    
    console.log("this.state", this.state)
    //console.log("state", state)

    if (this.state.keycloak) {
      if (this.state.authenticated) {

/*        if (this.props.isLogin.get('autorization') === '') {

          let name = this.state.keycloak.tokenParsed.email;
          let userName = this.state.keycloak.tokenParsed.name;
          let autorization = this.state.keycloak.token

          this.props.actions.isLogin('', name, userName, autorization, '');

        }
*/
        return (
          <div>
            <h1>Rick and Morty</h1>
            <p>Pick your favourite episodes</p>
          </div>
        )
      } else {
        return (
          <div>Unable to authenticate!</div>
        )
      }
    }

    return (
      <div>Initializing Keycloak...</div>
    )

  }
}

export default Security;