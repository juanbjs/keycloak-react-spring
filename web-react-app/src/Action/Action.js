import { SESSIONSTORE } from './Action-Types';
import axios from 'axios';

const API_URL = 'http://localhost:8080';

export const setSession = (dispatch, session) => {

  return dispatch({
    type: SESSIONSTORE,
    payload: session
  });
};

export async function getUsername(autorization) {

  let config = {
    headers: {
      'Access-Control-Allow-Origin': '*',
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + autorization
    }
  };

  const data = await axios.get(API_URL + '/midleware-service/api/v1/employees/username', config)
  const dataJSON = await data;
  
  console.log("data", data)
  console.log("dataJSON", dataJSON)

  return null;
}
